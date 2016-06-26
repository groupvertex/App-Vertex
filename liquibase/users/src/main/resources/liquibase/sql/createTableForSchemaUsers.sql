CREATE TABLE IF NOT EXISTS users.register_user (
  id         SERIAL      NOT NULL CONSTRAINT first_key PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  email      VARCHAR(50) NOT NULL UNIQUE,
  password   VARCHAR(50) NOT NULL
);
