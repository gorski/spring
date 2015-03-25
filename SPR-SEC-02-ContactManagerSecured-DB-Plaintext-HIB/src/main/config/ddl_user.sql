
-- users for security

USE contacts;

CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled boolean NOT NULL,
  PRIMARY KEY (username)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  UNIQUE(username, authority)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users VALUES ('tom', 'tomPASS', true);
INSERT INTO users VALUES ('ann', 'annPASS', true);
INSERT INTO authorities VALUES ('tom', 'ROLE_USER');
INSERT INTO authorities VALUES ('tom', 'ROLE_ADMIN');
INSERT INTO authorities VALUES ('ann', 'ROLE_USER');

CREATE TABLE com_users (
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled boolean NOT NULL,
  PRIMARY KEY (email)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE com_roles (
  email VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL,
  CONSTRAINT fk_roles_users FOREIGN KEY (email)
      REFERENCES com_users (email) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  UNIQUE(email, role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO com_users VALUES ('tom@firma.pl', 'tom', true);
INSERT INTO com_users VALUES ('ann@firma.pl', 'ann', true); 
INSERT INTO com_roles VALUES ('tom@firma.pl', 'ROLE_USER');
INSERT INTO com_roles VALUES ('tom@firma.pl', 'ROLE_ADMIN');
INSERT INTO com_roles VALUES ('ann@firma.pl', 'ROLE_USER');
