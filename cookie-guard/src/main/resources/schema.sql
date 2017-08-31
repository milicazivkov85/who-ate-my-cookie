DROP TABLE IF EXISTS auth.authorities;
DROP TABLE IF EXISTS auth.users;
DROP TABLE IF EXISTS auth.oauth_access_token;


create table IF NOT EXISTS auth.oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

create table IF NOT EXISTS auth.users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	enabled BOOLEAN NOT NULL
);

create table IF NOT EXISTS  auth.authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	UNIQUE KEY ix_auth_username (username,authority),
	CONSTRAINT fk_authorities_users foreign key(username) references auth.users(username)
);