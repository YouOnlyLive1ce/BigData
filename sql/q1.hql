USE team24_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results(
    metric_name STRING,
    metric_value STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

INSERT INTO q1_results
SELECT metric, value FROM (
  SELECT 'total_listings' AS metric, CAST(COUNT(*) AS STRING) AS value FROM airbnb
  UNION ALL
  SELECT 'avg_price', CAST(AVG(price) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'min_price', CAST(MIN(price) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'max_price', CAST(MAX(price) AS STRING) FROM airbnb
  UNION ALL
  SELECT 'median_price', CAST(PERCENTILE(CAST(price AS BIGINT), 0.5) AS STRING) FROM airbnb
) t;

SELECT * FROM q1_results;