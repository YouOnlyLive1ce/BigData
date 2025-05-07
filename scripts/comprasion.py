from pyspark.sql import SparkSession,DataFrame
from pyspark.ml.clustering import KMeans
from pyspark.ml.evaluation import ClusteringEvaluator
from pyspark.ml.linalg import Vectors, VectorUDT
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pprint import pprint
import pyspark.sql.functions as F
from pyspark.sql.types import StructType, StructField, StringType, ArrayType, DoubleType, IntegerType

# Add here your team number teamx
team = 24

spark = SparkSession.builder\
    .appName("teаm {} - spark ML model1 ".format(team))\
    .master("yarn")\
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
    .config("spark.hadoop.dfs.replication", "1") \
    .getOrCreate()

print(spark)

to_vector = F.udf(lambda x: Vectors.dense(x), VectorUDT())

schema = StructType([
    StructField("id", StringType(), True),
    StructField("features", ArrayType(DoubleType()), True)
])

hdfs_test_path = "hdfs:///user/team24/project/data/test"
test_data = spark.read.schema(schema).json(hdfs_test_path)
test_data = test_data.filter(F.size("features") > 0)
test_data = test_data.withColumn("features", to_vector(F.col("features")))
test_data = test_data.repartition(160)  # or calculated value

model_1_output_path = "hdfs:///user/team24/project/output/model1_predictions"
model_2_output_path = "hdfs:///user/team24/project/output/model2_predictions"

prediction_schema = StructType([
    StructField("id", StringType(), True),
    StructField("cluster", IntegerType(), True)
])

model_1_output = spark.read.schema(prediction_schema).csv(model_1_output_path).join(test_data, on='id')
model_2_output = spark.read.schema(prediction_schema).csv(model_2_output_path).join(test_data, on='id')


# Define safe evaluator
class SafeClusteringEvaluator(ClusteringEvaluator):
    def evaluate(self, dataset: DataFrame) -> float:
        pred_col = self.getPredictionCol()
        count = dataset.select(pred_col).distinct().count()
        if count < 2:
            return float('-inf')
        return super().evaluate(dataset)


# Create evaluator
evaluator = SafeClusteringEvaluator(
    metricName="silhouette",
    featuresCol="features",
    predictionCol="cluster"
)

# Оценка KMeans
silhouette_kmeans = evaluator.evaluate(model_1_output)

# Оценка Bisecting KMeans
silhouette_bisecting = evaluator.evaluate(model_2_output)

# Сравнение
comparison_df = spark.createDataFrame([
    ("KMeans", silhouette_kmeans),
    ("Bisecting KMeans", silhouette_bisecting)
], ["Model", "Silhouette Score"])

comparison_df.write.csv("hdfs:///user/team24/project/output/evaluation", mode="overwrite")
