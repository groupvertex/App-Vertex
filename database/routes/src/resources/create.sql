CREATE SCHEMA routes;
CREATE TABLE routes.waypoint (
  id int DEFAULT 100 ,
  track_id INTEGER,
  x        FLOAT,
  y        FLOAT,
  height   INTEGER,
  accuracy INTEGER,
  get_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT DID PRIMARY KEY (id)
);