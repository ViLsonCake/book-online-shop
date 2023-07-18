DROP TABLE IF EXISTS user_role;

CREATE TABLE IF NOT EXISTS user_role (
    user_id BIGINT NOT NULL,
    roles VARCHAR(32) NOT NULL
);