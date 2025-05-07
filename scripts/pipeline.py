'''Feature extraction pipeline'''
import math
import re
from pyspark.sql import SparkSession, DataFrame
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.feature import (
    Imputer, VectorAssembler, StandardScaler,
    StringIndexer, OneHotEncoder, Tokenizer,
    StopWordsRemover, Word2Vec
)
from pyspark.sql.functions import col, lit, coalesce, when, regexp_replace
from pyspark.sql.types import DoubleType, ArrayType
import pyspark.sql.functions as F
from pyspark.ml.util import MLWritable, MLReadable



# Custom Transformers
class GeodeticToECEFTransformer(Transformer, MLWritable, MLReadable):
    '''Transforms "latitude", "longitude" to absoulte values'''
    def __init__(self, input_cols=["latitude", "longitude"],
                 output_cols=["x", "y", "z"], altitude=0.0):
        super().__init__()
        self.input_cols = input_cols
        self.output_cols = output_cols
        self.altitude = altitude
        self.a = 6378137.0
        self.e2 = 6.69437999014e-3
        self.b = self.a * math.sqrt(1 - self.e2)

    def _transform(self, df: DataFrame) -> DataFrame:
        lat = F.radians(df[self.input_cols[0]])
        lon = F.radians(df[self.input_cols[1]])
        alt = F.lit(self.altitude)

        N = self.a / F.sqrt(1 - self.e2 * F.sin(lat)**2)
        x = (N + alt) * F.cos(lat) * F.cos(lon)
        y = (N + alt) * F.cos(lat) * F.sin(lon)
        z = ((self.a**2 / self.b**2) * (1 - self.e2)) * (N + alt) * F.sin(lat)

        return df.withColumn(self.output_cols[0], x) \
                 .withColumn(self.output_cols[1], y) \
                 .withColumn(self.output_cols[2], z)

    # Optional but useful: to allow reloading the model
    def copy(self, extra=None):
        """
        Creates a copy of this instance.
        """
        return super().copy(extra)

    # Save logic via MLWritable
    def write(self):
        """
        Writes this instance to disk in a format that can be read back by `read()`.
        """
        from pyspark.ml.util import DefaultParamsWriter
        return DefaultParamsWriter(self)

    # Load logic via MLReadable
    @staticmethod
    def read():
        """
        Returns a :py:class:`DefaultParamsReader` instance for this class.
        """
        from pyspark.ml.util import DefaultParamsReader
        return DefaultParamsReader(GeodeticToECEFTransformer)


# Team config
TEAM = 24
WAREHOUSE = 'project/hive/warehouse'

# Initialize Spark Session with optimizations
spark = SparkSession.builder \
    .appName(f"team {TEAM} - spark ML pipeline") \
    .master("yarn") \
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883") \
    .config("spark.sql.warehouse.dir", WAREHOUSE) \
    .config("spark.sql.avro.compression.codec", "snappy") \
    .config("spark.hadoop.dfs.replication", "1") \
    .enableHiveSupport() \
    .getOrCreate()


spark.sparkContext.setLogLevel("INFO")

print(spark)

# Load data
airbnb_df = spark.read.format("avro").table('team24_projectdb.airbnb')

# Repartition early to reduce shuffles later
airbnb_df = airbnb_df.repartition("city")


# Precompute frequent values for null filling
def get_most_frequent(df, col_name):
    return df.groupBy(col_name).count().orderBy("count", ascending=False).first()[0]


most_frequent_country = get_most_frequent(airbnb_df, "country")
most_frequent_state = get_most_frequent(airbnb_df, "state")


def data_transformation_pipeline(df):
    '''Fits pipeline on the df and returns pipeline and transformed data'''
    # Fill nulls in string/text columns
    df = df.na.fill({
        "name": "",
        "summary": "",
        "neighborhood_overview": "",
        "transit": ""
    })

    # Fill nulls in categorical columns
    most_frequent_country = df.groupBy("country") \
        .count().orderBy("count", ascending=False).first()[0]
    df = df.withColumn("country", coalesce(col("country"), lit(most_frequent_country)))
    df = df.withColumn("neighbourhood",coalesce(col("neighbourhood"), lit("Unknown")))
    most_frequent_state = df.groupBy("state") \
        .count().orderBy("count", ascending=False).first()[0]
    df = df.withColumn("state", coalesce(col("state"), lit(most_frequent_state)))

    # Fill nulls in numerical columns
    review_cols = [
        "review_scores_rating",
        "review_scores_cleanliness",
        "review_scores_location"
    ]
    df = df.na.fill(0, subset=review_cols)
    df = df.withColumn(
        "number_of_reviews",
        coalesce(col("number_of_reviews"), lit(0))
    )
    df = df.withColumn(
        "has_square_feet",
        when(col("square_feet").isNull(), 0).otherwise(1)
    )

    # Clean and cast numerical columns
    numerical_cols = [
        "accommodates", "bathrooms", "bedrooms", "beds", "price",
        "latitude", "longitude", "has_square_feet", "number_of_reviews",
        "review_scores_rating", "review_scores_cleanliness", "review_scores_location"
    ]
    df = df.withColumn("price", regexp_replace(col("price"), "[,$]", "").cast(DoubleType()))
    for col_name in numerical_cols:
        df = df.withColumn(col_name, col(col_name).cast(DoubleType()))

    # Impute latitude and longitude
    df = df.na.fill({"latitude": 0.0, "longitude": 0.0})

    # Text processing
    # Text processing
    text_cols = ["name", "summary", "neighborhood_overview", "transit"]
    tokenizers = [Tokenizer(inputCol=col, outputCol=f"{col}_tokens") for col in text_cols]
    removers = [StopWordsRemover(inputCol=f"{col}_tokens", outputCol=f"{col}_cleaned") for col in text_cols]

    WORD2VEC_SIZE = 64
    word2vec_models = [
        Word2Vec(
            inputCol=f"{col}_cleaned",
            outputCol=f"{col}_vec",
            vectorSize=WORD2VEC_SIZE,
            minCount=2
        ) for col in text_cols
    ]

    # Categorical encoding
    categorical_cols = ["property_type", "room_type", "neighbourhood", "city", "state"]
    indexers = [StringIndexer(inputCol=col, outputCol=f"{col}_index", handleInvalid="keep") for col in categorical_cols]
    encoders = [OneHotEncoder(inputCol=f"{col}_index", outputCol=f"{col}_vec") for col in categorical_cols]

    # Geodetic to ECEF
    geo_transformer = GeodeticToECEFTransformer(
        input_cols=["latitude", "longitude"],
        output_cols=["x", "y", "z"]
    )
    imputer = Imputer(
        inputCols=[
            "price", "bathrooms", "bedrooms", "review_scores_rating", "x", "y", "z"
        ],
        outputCols=[
            "price", "bathrooms", "bedrooms", "review_scores_rating", "x", "y", "z"
        ]
    ).setStrategy("mean")

    # Feature assembly
    assembler = VectorAssembler(
        inputCols=[
            "property_type_vec", "room_type_vec", "neighbourhood_vec", "city_vec", "state_vec",
            "name_vec", "summary_vec", "neighborhood_overview_vec", "transit_vec",
            "price", "bathrooms", "bedrooms", "review_scores_rating", "x", "y", "z"
        ],
        outputCol="raw_features"
    )
    # Standard scaling
    scaler = StandardScaler(
        inputCol="raw_features", 
        outputCol="features", 
        withMean=True, 
        withStd=True
    )

    # Build stages
    stages = (
        indexers + encoders +
        tokenizers + removers +
        word2vec_models +  # <-- Replaced TF-IDF with this
        [geo_transformer, imputer, assembler, scaler]
    )

    pipeline = Pipeline(stages=stages)
    model = pipeline.fit(df)
    transformed_data = model.transform(df)
    return model, transformed_data


pipeline_model, transformed_data = data_transformation_pipeline(airbnb_df)

transformed_data = transformed_data.select('id', 'features')

train_features, test_features = transformed_data.randomSplit([0.8, 0.2], seed=42)

to_array = F.udf(lambda v: v.toArray().tolist(), ArrayType(DoubleType()))
train_features = train_features.withColumn("features", to_array("features"))
test_features = test_features.withColumn("features", to_array("features"))

train_features = train_features.coalesce(4)  # Adjust based on size of data
test_features = test_features.coalesce(4)

# Define absolute paths
hdfs_train_path = "hdfs:///user/team24/project/data/train"
hdfs_test_path = "hdfs:///user/team24/project/data/test"

# Force evaluation to catch errors early
print("Train features count:", train_features.count())
print("Test features count:", test_features.count())

# Write to HDFS in JSON format
train_features.write \
    .mode("overwrite") \
    .format("json") \
    .option("codec", "org.apache.hadoop.io.compress.SnappyCodec") \
    .save(hdfs_train_path)

test_features.write \
    .mode("overwrite") \
    .format("json") \
    .option("codec", "org.apache.hadoop.io.compress.SnappyCodec") \
    .save(hdfs_test_path)

pipeline_model \
    .write() \
    .overwrite() \
    .save("hdfs:///user/team24/project/models/pipeline_model")

print("✅ Successfully saved train and test datasets in JSON format.")

spark.stop()