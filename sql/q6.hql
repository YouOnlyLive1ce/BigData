USE team24_projectdb;

DROP TABLE IF EXISTS q6_results;
CREATE EXTERNAL TABLE q6_results(
    city STRING,
    state STRING,
    country STRING,
    listing_count INT,
    avg_price FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

INSERT INTO q6_results
SELECT 
    city,
    state,
    country,
    COUNT(*) AS listing_count,
    AVG(price) AS avg_price
FROM airbnb
GROUP BY city, state, country
ORDER BY listing_count DESC
LIMIT 25;

SELECT * FROM q6_results LIMIT 25;