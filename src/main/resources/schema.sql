CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username varchar(1024),
    email varchar(1024),
    password varchar(1024)
);

INSERT INTO app_user (username, email, password) 
VALUES ('lilleswing', 'lilleswing@gmail.com', 'password');
