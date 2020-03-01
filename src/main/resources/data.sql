DROP TABLE IF EXISTS client;

CREATE TABLE client (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO client (name)
VALUES ('Koji'),
       ('Billy'),
       ('Ben'),
       ('Trololo'),
       ('Solomon'),
       ('Vasyanya');

DROP TABLE IF EXISTS procuration;

CREATE TABLE procuration (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  account DECIMAL NOT NULL,
  permissions VARCHAR(250) DEFAULT NULL,
  p_client_id INT DEFAULT NULL,
  p_client_name VARCHAR(250) DEFAULT NULL,
  a_client_id INT DEFAULT NULL,
  a_client_name VARCHAR(250) DEFAULT NULL
);