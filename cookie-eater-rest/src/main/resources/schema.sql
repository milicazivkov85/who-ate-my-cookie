DROP TABLE IF EXISTS sweets.cookie;
DROP TABLE IF EXISTS sweets.eater;

CREATE TABLE IF NOT EXISTS sweets.eater (
   id INT AUTO_INCREMENT PRIMARY KEY,
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   email VARCHAR(50),
   city VARCHAR(50),
   street VARCHAR(50),
   birthday DATE,
   username VARCHAR(50) NOT NULL,
   UNIQUE(username)
);

CREATE TABLE IF NOT EXISTS sweets.cookie (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   eater_id INT NOT NULL,
   CONSTRAINT fk_cookie_eater FOREIGN KEY (eater_id) REFERENCES sweets.eater (id) ON DELETE NO ACTION
);