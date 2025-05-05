USE team24_projectdb;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results(
    property_type STRING,
    count INT,
    percentage FLOAT,
    avg_price FLOAT,
    avg_rating FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

INSERT INTO q5_results
SELECT 
    property_type,
    COUNT(*) AS count,
    ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM airbnb), 2) AS percentage,
    AVG(price) AS avg_price,
    AVG(review_scores_rating) AS avg_rating
FROM airbnb
GROUP BY property_type
HAVING COUNT(*) > 10
ORDER BY count DESC;

SELECT * FROM q5_results;