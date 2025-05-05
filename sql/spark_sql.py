from pyspark.sql import SparkSession
import os

# Fix magic number problem
#find . -name "*.pyc" -exec rm -f {} \;

os.environ['HADOOP_CONF_DIR'] = '/etc/hadoop/conf'
os.environ['YARN_CONF_DIR'] = '/etc/hadoop/conf'

# Initialize Spark session with Hive support
# warehouse='Bigdata/hive/warehouse'
parquetpath='project/warehouse/airbnb'

spark = SparkSession.builder \
    .master("yarn")\
    .appName("Spark SQL Hive")\
    .config("spark.sql.catalogImplementation","hive")\
    .config("hive.metastore.uris","thrift://hadoop-02.uni.innopolis.ru:9883")\
    .config("spark.sql.warehouse.dir", parquetpath)\
    .enableHiveSupport() \
    .getOrCreate()

try:
    # Run HQL from python
    spark.sql("USE team24_projectdb;")
    spark.sql("show tables;").show()
    # Run HiveQL queries
    df = spark.sql("""SELECT COUNT(*) 
                    FROM temp_airbnb 
                    WHERE latitude IS NULL OR latitude = '' OR 
                    CAST(latitude AS DECIMAL(8,6)) IS NULL;""")
    df.show()

    # Read Parquet files from HDFS
    # df = spark.read.parquet(parquetpath)
    # print("=== Schema ===")
    # df.printSchema()
    # # Show first 10 rows
    # print("\n=== First 10 Rows ===")
    # df.show(10, truncate=False)
    # # Additional diagnostics
    # print("\n=== Additional Info ===")
    # print(df.count())
    # print(df.rdd.getNumPartitions())
    # print(', '.join(df.columns))

except Exception as e:
    print(str(e))
finally:
    spark.stop()