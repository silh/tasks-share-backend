CREATE SCHEMA IF NOT EXISTS tasks_share;
SET SCHEMA 'tasks_share';

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(200)  NOT NULL,
    password VARCHAR(200)  NOT NULL,
    email    VARCHAR(1000) NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks
(
    if          BIGSERIAL PRIMARY KEY,
    creator_id  BIGSERIAL REFERENCES users (id),
    name        VARCHAR(200) NOT NULL,
    description VARCHAR(1000)
);
