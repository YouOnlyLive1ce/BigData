DROP DATABASE IF EXISTS team24_projectdb CASCADE;
CREATE DATABASE team24_projectdb LOCATION "project/hive/warehouse";
USE team24_projectdb;

-- Enable ZSTD
-- Fill tables with dynamic partitioning (city) with nonstrictmode
-- We have 4000 distinct cities. mkdir goes brrr..
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

-- RAW Temporary table 
CREATE EXTERNAL TABLE IF NOT EXISTS temp_airbnb(
    id INT,
    name STRING,
    -- Neighbourhood properties
    neighborhood_overview STRING,
    transit STRING,
    neighbourhood STRING,
    city STRING, 
    state STRING,
    country STRING,-- In temporary tables we specify partition column
    zipcode STRING,
    -- Real Estate properties
    summary STRING,
    property_type STRING,
    room_type STRING,
    accommodates FLOAT,
    bathrooms FLOAT,
    bedrooms FLOAT,
    beds FLOAT,
    bed_type STRING,
    square_feet FLOAT,
    price FLOAT,
    -- Reviews
    number_of_reviews FLOAT,
    review_scores_rating FLOAT,
    review_scores_cleanliness FLOAT,
    review_scores_location FLOAT,
    -- Coordinates
    latitude STRING, -- In parquet this is string
    longitude STRING -- In parquet this is string
)
-- This table is unoptimized
-- PARTITIONED BY (country STRING)
-- CLUSTERED BY (latitude, longitude) INTO 32 BUCKETS
STORED AS PARQUET LOCATION 'project/warehouse/airbnb' -- location of folder with parts in hdfs:///user/team24/
TBLPROPERTIES ('parquet.compression'='SNAPPY',
               'parquet.enable.dictionary'='true');

-- This table is optimized, with correct types
CREATE EXTERNAL TABLE IF NOT EXISTS airbnb(
    id INT,
    name STRING,
    -- Neighbourhood properties
    neighborhood_overview STRING,
    transit STRING,
    neighbourhood STRING,
    city STRING, 
    state STRING,
    -- country STRING, -- In optimized we comment partitioning
    zipcode STRING,
    -- Real Estate properties
    summary STRING,
    property_type STRING,
    room_type STRING,
    accommodates FLOAT,
    bathrooms FLOAT,
    bedrooms FLOAT,
    beds FLOAT,
    bed_type STRING,
    square_feet FLOAT,
    price FLOAT,
    -- Reviews
    number_of_reviews FLOAT,
    review_scores_rating FLOAT,
    review_scores_cleanliness FLOAT,
    review_scores_location FLOAT,
    -- Coordinates
    latitude DECIMAL(8,6), -- casting string to decimal
    longitude DECIMAL(9,6) -- casting string to decimal
)
-- This table is optimized
PARTITIONED BY (country STRING)
CLUSTERED BY (latitude, longitude) INTO 32 BUCKETS
STORED AS PARQUET LOCATION 'project/hive/warehouse/airbnb_optimized'
TBLPROPERTIES ('parquet.compression'='SNAPPY',
               'parquet.enable.dictionary'='true');

INSERT OVERWRITE TABLE airbnb
PARTITION(country)
SELECT id, name, 
    neighborhood_overview, transit, neighbourhood,
    city, state, zipcode, 
    summary, property_type, room_type, accommodates, bathrooms, bedrooms, beds, bed_type, square_feet, price,
    number_of_reviews, review_scores_rating, review_scores_cleanliness, review_scores_location,
    CAST(latitude AS DECIMAL(8,6)) AS latitude, CAST(longitude AS DECIMAL(9,6)) AS longitude,
    country
FROM temp_airbnb;

DROP TABLE temp_airbnb;