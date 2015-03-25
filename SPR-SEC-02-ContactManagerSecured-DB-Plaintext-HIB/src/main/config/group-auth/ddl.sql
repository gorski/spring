
DROP DATABASE IF EXISTS contacts_ga;
CREATE DATABASE contacts_ga;
-- CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL ON *.* TO 'student'@'localhost' IDENTIFIED BY 'student';

USE contacts_ga;

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

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled boolean NOT NULL,
  PRIMARY KEY (email)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users VALUES ('tom@firma.pl', 'tom', true);
INSERT INTO users VALUES ('ann@firma.pl', 'ann', true); 

DROP TABLE IF EXISTS groups;
create table groups (
  id bigint primary key,
  group_name varchar(50) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO groups VALUES (1,'ADMINS');
INSERT INTO groups VALUES (2,'USERS');

DROP TABLE IF EXISTS group_authorities;
create table group_authorities (
  group_id bigint not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO group_authorities VALUES (1,'ROLE_USER');
INSERT INTO group_authorities VALUES (1,'ROLE_ADMIN');
INSERT INTO group_authorities VALUES (1,'ROLE_LIST');
INSERT INTO group_authorities VALUES (1,'ROLE_ADD');
INSERT INTO group_authorities VALUES (1,'ROLE_DELETE');

INSERT INTO group_authorities VALUES (2,'ROLE_USER');
INSERT INTO group_authorities VALUES (2,'ROLE_LIST');
INSERT INTO group_authorities VALUES (2,'ROLE_ADD');

DROP TABLE IF EXISTS group_members;
create table group_members (
  id bigint primary key,
  username varchar(50) not null,
  group_id bigint not null,
  constraint fk_group_members_username foreign key(username) references users(email),
  constraint fk_group_members_group foreign key(group_id) references groups(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO group_members VALUES (1,'tom@firma.pl',1);
INSERT INTO group_members VALUES (2,'ann@firma.pl',2);

-- mysql -u root -p < ddl.sql
-- Enter password: root
