USE team24_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results(
    room_type STRING,
    count INT,
    avg_price FLOAT,
    min_price FLOAT,
    max_price FLOAT,
    median_price FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

INSERT INTO q3_results
SELECT 
    room_type,
    COUNT(*) AS count,
    AVG(price) AS avg_price,
    MIN(price) AS min_price,
    MAX(price) AS max_price,
    PERCENTILE(CAST(price AS BIGINT), 0.5) AS median_price
FROM airbnb
GROUP BY room_type
ORDER BY avg_price DESC;

SELECT * FROM q3_results;