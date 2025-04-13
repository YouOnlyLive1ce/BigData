START TRANSACTION;

DROP TABLE IF EXISTS airbnb;

-- Add table
CREATE TABLE IF NOT EXISTS airbnb (
    ID integer NOT NULL PRIMARY KEY,
    name TEXT,
    -- Neigbourhood properties
    neighborhood_overview TEXT,
    transit TEXT,
    neighbourhood TEXT,
    city TEXT,
    state TEXT,
    country TEXT,
    zipcode TEXT,
    -- Real Estate properties
    summary TEXT,
    property_type TEXT,
    room_type TEXT,
    accommodates FLOAT,
    bathrooms FLOAT,
    bedrooms FLOAT,
    beds FLOAT,
    bed_type TEXT,
    square_feet FLOAT,
    price FLOAT,
    -- Reviews
    number_of_reviews FLOAT,  
    review_scores_rating FLOAT,  
    review_scores_cleanliness FLOAT,
    review_scores_location FLOAT,
    -- Coordinates
    latitude decimal(8, 6),
    longitude decimal(9, 6)
);

DROP INDEX IF EXISTS latitude_idx;
DROP INDEX IF EXISTS longitude_idx;

-- Create index on 
-- for 1000 rows gives speed up from 1.5+-0.5 to 1+-0.3
CREATE INDEX latitude_idx on airbnb USING BTREE (latitude);
CREATE INDEX longitude_idx on airbnb USING BTREE (longitude);

COMMIT;