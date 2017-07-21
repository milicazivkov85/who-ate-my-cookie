INSERT INTO sweets.users (username, password, enabled) VALUES ('user', 'user', 1);
INSERT INTO sweets.authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO sweets.users (username, password, enabled) VALUES ('milica', 'milica', 1);
INSERT INTO sweets.authorities (username, authority) VALUES ('milica', 'ROLE_USER');

INSERT INTO sweets.users (username, password, enabled) VALUES ('admin', 'admin', 1);
INSERT INTO sweets.authorities (username, authority) VALUES ('admin', 'ROLE_USER');