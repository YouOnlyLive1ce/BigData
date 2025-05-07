-- 
--DROP DATABASE IF EXISTS team24_projectdb CASCADE;
--CREATE DATABASE team24_projectdb LOCATION "project/hive/warehouse";
USE team24_projectdb;

-- Enable ZSTD
-- Fill tables with dynamic partitioning (city) with nonstrictmode
-- We have 60 distinct countries. mkdir goes brrr..
-- SET hive.exec.compress.output=true;
-- SET parquet.compression=ZSTD;
SET hive.exec.max.dynamic.partitions=100;
SET hive.exec.max.dynamic.partitions.pernode=30;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
SET hive.execution.engine=tez;

SET mapreduce.map.memory.mb=4096;
SET mapreduce.reduce.memory.mb=8192;
SET hive.exec.reducers.bytes.per.reducer=256000000;

DROP TABLE IF EXISTS airbnb_model1_clusters;

CREATE EXTERNAL TABLE IF NOT EXISTS airbnb_model1_clusters(
    id INT,
    cluster_number INT
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
STORED AS TEXTFILE  -- Changed from PARQUET to TEXTFILE for CSV
LOCATION 'project/output/model1_predictions'
TBLPROPERTIES (
    'skip.header.line.count'='1',
    'serialization.null.format'=''  -- Handle empty values
);

DROP TABLE IF EXISTS airbnb_model2_clusters;

CREATE EXTERNAL TABLE IF NOT EXISTS airbnb_model2_clusters(
    id INT,
    cluster_number INT
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
STORED AS TEXTFILE  -- Changed from PARQUET to TEXTFILE for CSV
LOCATION 'project/output/model2_predictions'
TBLPROPERTIES (
    'skip.header.line.count'='1',
    'serialization.null.format'=''  -- Handle empty values
);