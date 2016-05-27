CREATE SCHEMA users;

CREATE TABLE users.register_user (
  id         INTEGER,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  email      VARCHAR(50) NOT NULL,
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