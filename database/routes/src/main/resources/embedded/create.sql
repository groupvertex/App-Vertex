CREATE SCHEMA routes;

CREATE TABLE routes.route (
  id   BIGINT,
  name VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE routes.waypoint (
  id       BIGINT,
  track_id BIGINT,
  x        FLOAT,
  y        FLOAT,
  height   INTEGER,
  accuracy INTEGER,
  get_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (track_id) REFERENCES routes.route (id)
);