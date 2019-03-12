DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id VARCHAR(255) PRIMARY KEY,
	email VARCHAR(255), 
	password VARCHAR(255),
	enabled BOOLEAN
	);
INSERT INTO users VALUES('1', 'cmeyerwps@gmail.com', 'password', true);
INSERT INTO users VALUES('2', 'jdoss@wps.org', 'password2', false);