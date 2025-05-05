# Either use elastic search as is, having two nodes
from elasticsearch import Elasticsearch
es = Elasticsearch("http://localhost:9200")
if es.ping():
    print("Connected to Elasticsearch!")
else:
    print("Connection failed.")




# Either upload data to hive
from pyspark.sql import SparkSession

spark = SparkSession.builder \
    .appName("ES-to-Hive") \
    .config("spark.jars.packages", "org.elasticsearch:elasticsearch-spark-30_2.12:8.11.0") \
    .getOrCreate()

es_df = spark.read \
    .format("org.elasticsearch.spark.sql") \
    .option("es.nodes", "localhost") \
    .option("es.port", "9200") \
    .option("es.resource", "employees_elasticsearch") \
    .load()
es_df.write.parquet("hdfs:///user/hadoop/employees_elasticsearch.parquet")
es_df.write.saveAsTable("employees_elasticsearch")  # Direct to Hive
# CREATE EXTERNAL TABLE employees_elasticsearch 
# STORED AS PARQUET
# LOCATION 'hdfs:///user/hadoop/employees_elasticsearch.parquet';

sharded distributed
_cat/shards