DROP TABLE IF EXISTS sweets.cookie;

CREATE TABLE IF NOT EXISTS sweets.cookie (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   username VARCHAR(50) NOT NULL,
   CONSTRAINT fk_cookie_user FOREIGN KEY (username) REFERENCES sweets.users (username) ON DELETE NO ACTION
);