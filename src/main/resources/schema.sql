DROP SCHEMA tasksshare; --TODO remove this later
CREATE SCHEMA tasksshare;

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(200) NOT NULL,
    password VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS tasks
(
    if          bigserial PRIMARY KEY,
    creator_id  bigserial REFERENCES users (id),
    name        VARCHAR(200) NOT NULL,
    description VARCHAR(1000)
);
