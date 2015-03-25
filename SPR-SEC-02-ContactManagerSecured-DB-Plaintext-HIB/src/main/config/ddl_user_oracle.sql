
-- users for security
CREATE TABLE users
(
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled NUMBER(1,0) NOT NULL
);

ALTER TABLE users
ADD CONSTRAINT users_PK PRIMARY KEY
(
username
);
 
 
CREATE TABLE authorities
(
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL
);


ALTER TABLE authorities
ADD CONSTRAINT authorities_UK UNIQUE
(
username, authority
);

ALTER TABLE authorities
ADD CONSTRAINT fk_authorities_users FOREIGN KEY
(
username
)
REFERENCES users
(
username
);


INSERT INTO users VALUES ('tom', 'tomPASS', 1);
INSERT INTO users VALUES ('ann', 'annPASS', 1);
-- INSERT INTO users VALUES ('tom', 'tomPASS', true); -- tomPASS{tom} MD5: 36d0639bd4ee494e01eb61b55b2afa0a
-- INSERT INTO users VALUES ('ann', 'annPASS', true); -- annPASS{ann} MD5: 6a7e42cf455888c4638a91e283df7301
 
INSERT INTO authorities VALUES ('tom', 'ROLE_USER');
INSERT INTO authorities VALUES ('tom', 'ROLE_ADMIN');
INSERT INTO authorities VALUES ('ann', 'ROLE_USER');
