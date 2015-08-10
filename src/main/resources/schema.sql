CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username varchar(1024),
    email varchar(1024),
    password varchar(1024)
);

INSERT INTO app_user (username, email, password)
VALUES ('lilleswing', 'lilleswing@gmail.com', 'password');

CREATE TABLE task (
    id SERIAL PRIMARY KEY ,
    name varchar(1024),
    description text,
    difficulty INTEGER
);

INSERT INTO task (name, description, difficulty)
    VALUES ('Watch The Terminator', 'Terminator Description', 1);
