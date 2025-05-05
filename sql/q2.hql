USE team24_projectdb;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results(
    metric_name STRING,
    metric_value STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2';;

INSERT INTO q2_results
SELECT metric, value FROM (
  SELECT 'avg_rating' AS metric, CAST(AVG(review_scores_rating) AS STRING) AS value FROM airbnb
  UNION ALL
  SELECT 'avg_bathrooms', CAST(AVG(bathrooms) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'avg_bedrooms', CAST(AVG(bedrooms) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'avg_beds', CAST(AVG(beds) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'avg_accommodates', CAST(AVG(accommodates) AS STRING) FROM airbnb
) t;

SELECT * FROM q2_results;