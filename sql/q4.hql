USE team24_projectdb;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results(
    neighbourhood STRING,
    city STRING,
    listing_count INT,
    avg_price FLOAT,
    avg_rating FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

INSERT INTO q4_results
SELECT 
    neighbourhood,
    city,
    COUNT(*) AS listing_count,
    AVG(price) AS avg_price,
    AVG(review_scores_rating) AS avg_rating
FROM airbnb
GROUP BY neighbourhood, city
ORDER BY listing_count DESC
LIMIT 25;

SELECT * FROM q4_results;