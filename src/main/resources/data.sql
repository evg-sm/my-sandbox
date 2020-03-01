DROP TABLE IF EXISTS public.client;

CREATE TABLE public.client (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          name VARCHAR(250) NOT NULL
);

INSERT INTO public.client (name)
VALUES ('Koji'),
       ('Billy'),
       ('Ben'),
       ('Trololo'),
       ('Solomon'),
       ('Vasyanya');

DROP TABLE IF EXISTS test_tab;

CREATE TABLE test_tab (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO test_tab (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');