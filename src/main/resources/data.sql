SET SCHEMA 'tasks_share';

INSERT INTO users (id, name, password, email)
VALUES (nextval('users_id_seq'), 'silh', '123', 'some@email.com');
