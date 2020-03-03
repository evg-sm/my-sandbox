DROP TABLE IF EXISTS client;

CREATE TABLE client (
    client_id INT AUTO_INCREMENT  PRIMARY KEY,
    branch_id INT NOT NULL,
    category_id INT NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    middle_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    translit_name VARCHAR(250) NOT NULL,
    DOB date NOT NULL,
    POB VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    legal_address VARCHAR(250) NOT NULL,
    phone VARCHAR(250) NOT NULL
);

INSERT INTO client (branch_id, category_id, first_name, middle_name, last_name, translit_name, DOB, POB, email, legal_address, phone)
VALUES (200, 70, 'Koji', 'K', 'Fokusima', 'Koji K Fokusima', '1980-05-30', 'Fokusima', '1@mail.ru', 'address1', '926-000-00-01'),
       (200, 50, 'Billy', 'F', 'Smith', 'Billy F Smith', '2000-05-30', 'New York', '2@mail.ru', 'address2', '926-000-00-02'),
       (200, 11, 'Solomon', 'Shnipersonovish', 'Goldman', 'Solomon Shnipersonovish Goldman', '2000-05-30', 'Waclaw', '3@mail.ru', 'address2', '926-000-00-03'),
       (200, 12, 'Ion', 'E', 'Slow', 'Ion E Slow', '1979-01-11', 'Nebraska', '4@mail.ru', 'address2', '926-000-00-04'),
       (200, 99, 'Ben', 'Van', 'Kenobi', 'Ben Van Kenobi', '1967-02-09', 'Korusant', '5@mail.ru', 'address5', '926-000-00-05');

DROP TABLE IF EXISTS procuration;

CREATE TABLE procuration (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  account DECIMAL NOT NULL,
  action INT DEFAULT NULL,
  p_client_id INT DEFAULT NULL,
  p_client_name VARCHAR(250) DEFAULT NULL,
  a_client_id INT DEFAULT NULL,
  a_client_name VARCHAR(250) DEFAULT NULL
);