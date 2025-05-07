from pyspark.ml.clustering import BisectingKMeans
from pyspark.ml.evaluation import ClusteringEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pprint import pprint
from pyspark.sql import SparkSession, DataFrame
from pyspark.ml.linalg import Vectors, VectorUDT
from pprint import pprint
import pyspark.sql.functions as F
from pyspark.sql.types import StructType, StructField, StringType, ArrayType, DoubleType

# Add here your team number teamx
team = 24

hdfs_train_path = "hdfs:///user/team24/project/data/train"
hdfs_test_path = "hdfs:///user/team24/project/data/test"

spark = SparkSession.builder\
    .appName("teаm {} - spark ML model2 ".format(team))\
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

# Bisecting KMeans
bisecting_km = BisectingKMeans(featuresCol="features", predictionCol="cluster")

# Гиперпараметры
param_grid_bisecting = ParamGridBuilder() \
    .addGrid(bisecting_km.k, [5, 10]) \
    .addGrid(bisecting_km.minDivisibleClusterSize, [2.0, 4.0]) \
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
cv_bisecting = CrossValidator(estimator=bisecting_km,
                              estimatorParamMaps=param_grid_bisecting,
                              evaluator=evaluator,
                              numFolds=3)

# Обучение
cv_bisecting_model = cv_bisecting.fit(train_data)

# Лучшая модель
best_bisecting = cv_bisecting_model.bestModel

pprint(best_bisecting.extractParamMap())

# Сохранение модели
best_bisecting.write().overwrite().save("hdfs:///user/team24/project/models/model2")

# Предсказание
predictions_bisecting = best_bisecting.transform(test_data)
predictions_bisecting.select("id", "cluster").write.csv("hdfs:///user/team24/project/output/model2_predictions", mode="overwrite")
