-- Not used query
DROP DATABASE IF EXISTS team24_projectdb CASCADE;
CREATE DATABASE team24_projectdb LOCATION "project/hive/warehouse";
USE team24_projectdb;

-- Add Handler (not driver)
-- ADD JAR /path/to/elasticsearch-hadoop.jar;

-- Here we inform Hive that we already have ready database via TBLPROPERTIES
-- Handler hive-es will call elastic api and get data to hive
CREATE EXTERNAL TABLE airbnb_es (
  employee_id STRING,
  name STRING,
  department STRING,
  salary FLOAT
)
STORED BY 'org.elasticsearch.hadoop.hive.EsStorageHandler'
TBLPROPERTIES (
  'es.resource' = 'employees-index/employees-type',
  'es.nodes' = 'elasticsearch-host:9200',
  'es.mapping.names' = 'employee_id:_id, name:full_name',
  'es.read.metadata' = 'true',
  'es.mapping.id' = 'employee_id'
);

