CREATE DATABASE movies;
USE movies;

CREATE TABLE directors(
    id int PRIMARY KEY AUTO_INCREMENT,
    director_name varchar(50) NOT NULL,
    notes text);

INSERT INTO directors(director_name, notes)
VALUES ('TestName1', 'TestNotes'),
       ('TestName2', 'TestNotes'),
       ('TestName3', 'TestNotes'),
       ('TestName4', 'TestNotes'),
       ('TestName5', 'TestNotes');

CREATE TABLE genres(
    id int PRIMARY KEY AUTO_INCREMENT,
    genre_name varchar(20) NOT NULL,
    notes text
);

INSERT INTO genres(genre_name, notes)
VALUES ('TestName1', 'TestNotes'),
       ('TestName2', 'TestNotes'),
       ('TestName3', 'TestNotes'),
       ('TestName4', 'TestNotes'),
       ('TestName5', 'TestNotes');

CREATE TABLE categories(
    id int PRIMARY KEY AUTO_INCREMENT,
    category_name varchar(20) NOT NULL,
    notes text
);

INSERT INTO categories(category_name, notes)
VALUES ('TestName1', 'TestNotes'),
       ('TestName2', 'TestNotes'),
       ('TestName3', 'TestNotes'),
       ('TestName4', 'TestNotes'),
       ('TestName5', 'TestNotes');

# movies (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes)
# title cannot be null

CREATE TABLE movies(
    id int PRIMARY KEY AUTO_INCREMENT,
    title varchar(40) NOT NULL ,
    director_id int,
    copyright_year int,
    length int,
    genre_id int,
    category_id int,
    rating double,
    notes text
);

INSERT INTO movies(title)
VALUES ('TestMovie1'),
       ('TestMovie2'),
       ('TestMovie3'),
       ('TestMovie4'),
       ('TestMovie5');