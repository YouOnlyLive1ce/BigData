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

hdfs_train_path = "hdfs:///user/team24/project/data/train"
hdfs_test_path = "hdfs:///user/team24/project/data/test"

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

train_data = spark.read.schema(schema).json(hdfs_train_path)
train_data = train_data.filter(F.size("features") > 0)
train_data = train_data.withColumn("features", to_vector(F.col("features")))

# 4. Now is a good time to repartition
train_data = train_data.repartition(160)  # or calculated value

# 5. Cache if reused (e.g., in cross-validation)
train_data = train_data.cache()

test_data = spark.read.schema(schema).json(hdfs_test_path)
test_data = test_data.filter(F.size("features") > 0)
test_data = test_data.withColumn("features", to_vector(F.col("features")))

# 4. Now is a good time to repartition
train_data = train_data.repartition(160)  # or calculated value

# 5. Cache if reused (e.g., in cross-validation)
train_data = train_data.cache()

# KMeans
kmeans = KMeans(featuresCol="features", predictionCol="cluster", maxIter=10)

# Гиперпараметры
param_grid = ParamGridBuilder() \
    .addGrid(kmeans.k, [5, 10]) \
    .addGrid(kmeans.initMode, ["k-means||", "random"]) \
    .build()


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

# Кросс-валидация
cv = CrossValidator(estimator=kmeans,
                    estimatorParamMaps=param_grid,
                    evaluator=evaluator,
                    numFolds=2)

# Обучение
cv_model = cv.fit(train_data)

# Лучшая модель
best_kmeans = cv_model.bestModel

pprint(best_kmeans.extractParamMap())

# Сохранение модели
best_kmeans.write().overwrite().save("hdfs:///user/team24/project/models/model1")

predictions_kmeans = best_kmeans.transform(test_data)
predictions_kmeans \
    .select("id", "cluster") \
    .write.csv("hdfs:///user/team24/project/output/model1_predictions", mode="overwrite")