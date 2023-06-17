CREATE DATABASE minions_db;
USE minions_db;

CREATE TABLE towns(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL ,
  country VARCHAR(20)
);

CREATE TABLE villains(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  evilness_factor ENUM('good', 'bad', 'evil', 'super evil')
);

CREATE TABLE minions(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  age INT(11) NOT NULL ,
  town_id INT(11),
  CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES towns(id)
);

CREATE TABLE minions_villains(
  minion_id INT(11),
  villain_id INT(11),
  CONSTRAINT fk_minions_villains FOREIGN KEY (minion_id) REFERENCES minions(id),
  CONSTRAINT fk_villains_minions FOREIGN KEY (villain_id) REFERENCES villains(id)
);

insert into towns (id, name, country) values (1, 'Sofia', 'Bulgaria');
insert into towns (id, name, country) values (2, 'Plovdiv', 'Bulgaria');
insert into towns (id, name, country) values (3, 'Burgas', 'Bulgaria');
insert into towns (id, name, country) values (4, 'Berlin', 'Germany');
insert into towns (id, name, country) values (5, 'London', 'England');

insert into villains (id, name, evilness_factor) values (1, 'Carl', 'good');
insert into villains (id, name, evilness_factor) values (2, 'Crissy', 'bad');
insert into villains (id, name, evilness_factor) values (3, 'Arabele', 'bad');
insert into villains (id, name, evilness_factor) values (4, 'Sheeree', 'evil');
insert into villains (id, name, evilness_factor) values (5, 'Flo', 'super evil');
insert into villains (id, name, evilness_factor) values (6, 'Minionless', 'good');

insert into minions (id, name, age, town_id) values (1, 'May', 44, 4);
insert into minions (id, name, age, town_id) values (2, 'Brina', 43, 5);
insert into minions (id, name, age, town_id) values (3, 'Roslyn', 50, 4);
insert into minions (id, name, age, town_id) values (4, 'Virgie', 53, 2);
insert into minions (id, name, age, town_id) values (5, 'Nananne', 23, 1);
insert into minions (id, name, age, town_id) values (6, 'Gayleen', 14, 1);
insert into minions (id, name, age, town_id) values (7, 'Ole', 53, 1);
insert into minions (id, name, age, town_id) values (8, 'Eldredge', 32, 2);
insert into minions (id, name, age, town_id) values (9, 'Marge', 16, 4);
insert into minions (id, name, age, town_id) values (10, 'Vi', 49, 3);
insert into minions (id, name, age, town_id) values (11, 'Ilka', 17, 4);
insert into minions (id, name, age, town_id) values (12, 'Pancho', 53, 5);
insert into minions (id, name, age, town_id) values (13, 'Stephi', 31, 5);
insert into minions (id, name, age, town_id) values (14, 'Cobby', 21, 5);
insert into minions (id, name, age, town_id) values (15, 'Florence', 67, 5);
insert into minions (id, name, age, town_id) values (16, 'Ardeen', 52, 3);
insert into minions (id, name, age, town_id) values (17, 'Sax', 28, 3);
insert into minions (id, name, age, town_id) values (18, 'Shurlocke', 33, 3);
insert into minions (id, name, age, town_id) values (19, 'Orsola', 16, 3);
insert into minions (id, name, age, town_id) values (20, 'Anselm', 59, 1);
insert into minions (id, name, age, town_id) values (21, 'Noble', 17, 3);
insert into minions (id, name, age, town_id) values (22, 'Colin', 13, 4);
insert into minions (id, name, age, town_id) values (23, 'Minette', 29, 4);
insert into minions (id, name, age, town_id) values (24, 'Katine', 23, 4);
insert into minions (id, name, age, town_id) values (25, 'Chevalier', 53, 2);
insert into minions (id, name, age, town_id) values (26, 'Abbe', 17, 5);
insert into minions (id, name, age, town_id) values (27, 'Skipp', 16, 1);
insert into minions (id, name, age, town_id) values (28, 'Wilhelm', 11, 4);
insert into minions (id, name, age, town_id) values (29, 'Madelyn', 41, 1);
insert into minions (id, name, age, town_id) values (30, 'Bryant', 50, 4);
insert into minions (id, name, age, town_id) values (31, 'Davey', 22, 4);
insert into minions (id, name, age, town_id) values (32, 'Jasen', 68, 4);
insert into minions (id, name, age, town_id) values (33, 'Dominique', 67, 2);
insert into minions (id, name, age, town_id) values (34, 'Mella', 63, 4);
insert into minions (id, name, age, town_id) values (35, 'Gaye', 22, 4);
insert into minions (id, name, age, town_id) values (36, 'Pearl', 48, 2);
insert into minions (id, name, age, town_id) values (37, 'Rozella', 20, 4);
insert into minions (id, name, age, town_id) values (38, 'Marika', 47, 1);
insert into minions (id, name, age, town_id) values (39, 'Annabella', 34, 4);
insert into minions (id, name, age, town_id) values (40, 'Jeffry', 48, 3);
insert into minions (id, name, age, town_id) values (41, 'Fiann', 51, 2);
insert into minions (id, name, age, town_id) values (42, 'Burgess', 15, 4);
insert into minions (id, name, age, town_id) values (43, 'Loydie', 51, 2);
insert into minions (id, name, age, town_id) values (44, 'Hermia', 56, 4);
insert into minions (id, name, age, town_id) values (45, 'Reggy', 34, 2);
insert into minions (id, name, age, town_id) values (46, 'Norah', 19, 4);
insert into minions (id, name, age, town_id) values (47, 'Lu', 26, 4);
insert into minions (id, name, age, town_id) values (48, 'Theodor', 66, 4);
insert into minions (id, name, age, town_id) values (49, 'Tara', 40, 5);
insert into minions (id, name, age, town_id) values (50, 'Brandie', 32, 3);

insert into minions_villains (minion_id, villain_id) values (39, 1);
insert into minions_villains (minion_id, villain_id) values (8, 1);
insert into minions_villains (minion_id, villain_id) values (40, 4);
insert into minions_villains (minion_id, villain_id) values (6, 2);
insert into minions_villains (minion_id, villain_id) values (38, 5);
insert into minions_villains (minion_id, villain_id) values (35, 1);
insert into minions_villains (minion_id, villain_id) values (27, 2);
insert into minions_villains (minion_id, villain_id) values (2, 5);
insert into minions_villains (minion_id, villain_id) values (40, 5);
insert into minions_villains (minion_id, villain_id) values (11, 5);
insert into minions_villains (minion_id, villain_id) values (40, 2);
insert into minions_villains (minion_id, villain_id) values (10, 1);
insert into minions_villains (minion_id, villain_id) values (37, 2);
insert into minions_villains (minion_id, villain_id) values (31, 3);
insert into minions_villains (minion_id, villain_id) values (8, 1);
insert into minions_villains (minion_id, villain_id) values (48, 2);
insert into minions_villains (minion_id, villain_id) values (19, 3);
insert into minions_villains (minion_id, villain_id) values (28, 2);
insert into minions_villains (minion_id, villain_id) values (2, 5);
insert into minions_villains (minion_id, villain_id) values (25, 5);
insert into minions_villains (minion_id, villain_id) values (37, 1);
insert into minions_villains (minion_id, villain_id) values (12, 2);
insert into minions_villains (minion_id, villain_id) values (44, 5);
insert into minions_villains (minion_id, villain_id) values (47, 3);
insert into minions_villains (minion_id, villain_id) values (22, 4);
insert into minions_villains (minion_id, villain_id) values (4, 5);
insert into minions_villains (minion_id, villain_id) values (45, 3);
insert into minions_villains (minion_id, villain_id) values (46, 2);
insert into minions_villains (minion_id, villain_id) values (44, 2);
insert into minions_villains (minion_id, villain_id) values (35, 5);
insert into minions_villains (minion_id, villain_id) values (48, 1);
insert into minions_villains (minion_id, villain_id) values (11, 2);
insert into minions_villains (minion_id, villain_id) values (37, 5);
insert into minions_villains (minion_id, villain_id) values (38, 4);
insert into minions_villains (minion_id, villain_id) values (3, 5);
insert into minions_villains (minion_id, villain_id) values (19, 1);
insert into minions_villains (minion_id, villain_id) values (37, 3);
insert into minions_villains (minion_id, villain_id) values (50, 4);
insert into minions_villains (minion_id, villain_id) values (21, 1);
insert into minions_villains (minion_id, villain_id) values (34, 3);
insert into minions_villains (minion_id, villain_id) values (29, 5);
insert into minions_villains (minion_id, villain_id) values (43, 4);
insert into minions_villains (minion_id, villain_id) values (10, 2);
insert into minions_villains (minion_id, villain_id) values (34, 2);
insert into minions_villains (minion_id, villain_id) values (29, 5);
insert into minions_villains (minion_id, villain_id) values (17, 4);
insert into minions_villains (minion_id, villain_id) values (11, 2);
insert into minions_villains (minion_id, villain_id) values (41, 1);
insert into minions_villains (minion_id, villain_id) values (23, 1);
insert into minions_villains (minion_id, villain_id) values (22, 5);
insert into minions_villains (minion_id, villain_id) values (3, 1);
insert into minions_villains (minion_id, villain_id) values (22, 3);
insert into minions_villains (minion_id, villain_id) values (24, 2);
insert into minions_villains (minion_id, villain_id) values (30, 3);
insert into minions_villains (minion_id, villain_id) values (41, 5);
insert into minions_villains (minion_id, villain_id) values (38, 1);
insert into minions_villains (minion_id, villain_id) values (12, 1);
insert into minions_villains (minion_id, villain_id) values (48, 3);
insert into minions_villains (minion_id, villain_id) values (37, 3);
insert into minions_villains (minion_id, villain_id) values (30, 2);
insert into minions_villains (minion_id, villain_id) values (7, 3);
insert into minions_villains (minion_id, villain_id) values (25, 4);
insert into minions_villains (minion_id, villain_id) values (26, 1);
insert into minions_villains (minion_id, villain_id) values (40, 3);
insert into minions_villains (minion_id, villain_id) values (44, 4);
insert into minions_villains (minion_id, villain_id) values (45, 5);
insert into minions_villains (minion_id, villain_id) values (20, 5);
insert into minions_villains (minion_id, villain_id) values (41, 4);
insert into minions_villains (minion_id, villain_id) values (40, 4);
insert into minions_villains (minion_id, villain_id) values (40, 5);
insert into minions_villains (minion_id, villain_id) values (24, 5);
insert into minions_villains (minion_id, villain_id) values (17, 4);
insert into minions_villains (minion_id, villain_id) values (8, 1);
insert into minions_villains (minion_id, villain_id) values (13, 3);
insert into minions_villains (minion_id, villain_id) values (42, 3);