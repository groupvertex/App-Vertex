DROP SCHEMA IF EXISTS routes;
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
  FOREIGN KEY (track_id) REFERENCES routes.route (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP SCHEMA IF EXISTS users;
CREATE SCHEMA users;

CREATE TABLE users.register_user (
  id         BIGINT,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  email      VARCHAR(50) NOT NULL UNIQUE,
  password   VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users.payment (
  id      BIGINT,
  user_id BIGINT,
  amount  INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users.register_user (id)
);

DROP SCHEMA IF EXISTS config;
CREATE SCHEMA config;

CREATE TABLE config.config (
  key VARCHAR(50),
  value VARCHAR(50),
  PRIMARY KEY (key)
)