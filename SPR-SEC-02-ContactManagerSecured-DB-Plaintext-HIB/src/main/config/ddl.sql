
CREATE DATABASE contacts;
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL ON *.* TO 'student'@'localhost' IDENTIFIED BY 'student';

USE contacts;

DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
  id         INT NOT NULL auto_increment,
  firstname  VARCHAR(30),
  lastname   VARCHAR(30),
  phone      VARCHAR(15),
  email      VARCHAR(30),
  created    TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mysql -u root -p < ddl.sql
-- Enter password: root

