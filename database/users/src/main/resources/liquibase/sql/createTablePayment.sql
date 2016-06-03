CREATE TABLE IF NOT EXISTS users.payment (
  id      BIGINT NOT NULL CONSTRAINT fourth_key PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES users.register_user (id) ON DELETE CASCADE ON UPDATE CASCADE,
  amount  INTEGER DEFAULT 0
);
