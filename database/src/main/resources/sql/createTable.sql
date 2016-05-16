CREATE TABLE IF NOT EXISTS register_user(
  id         SERIAL      NOT NULL CONSTRAINT first_key PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  email      VARCHAR(50) NOT NULL,
  password   VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS route(
  id   SERIAL      NOT NULL CONSTRAINT second_key PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS waypoint(
  id       SERIAL  NOT NULL CONSTRAINT third_key PRIMARY KEY,
  track_id INTEGER NOT NULL REFERENCES route (id),
  x        FLOAT   NOT NULL,
  y        FLOAT   NOT NULL,
  height   INTEGER NOT NULL,
  accuracy INTEGER,
  get_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (now() AT TIME ZONE 'utc')
);
