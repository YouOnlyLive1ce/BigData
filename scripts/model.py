from pyspark.sql import SparkSession

# Add here your team number teamx
team = 24

warehouse = 'project/hive/warehouse'

spark = SparkSession.builder\
    .appName("teаm {} - spark ML".format(team))\
    .master("yarn")\
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
    .config("spark.sql.warehouse.dir", warehouse)\
    .config("spark.sql.avro.compression.codec", "snappy")\
    .enableHiveSupport()\
    .getOrCreate()

print(spark)

spark.sql("SHOW DATABASES").show(100)
spark.sql(f"USE team{team24}_projectdb").show()
spark.sql("SHOW TABLES").show()