CREATE TABLE people(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `name`      VARCHAR(200) NOT NULL,
    `picture`   MEDIUMBLOB,
    `height`    FLOAT,
    `weight`    FLOAT,
    `gender`    CHAR(1)      NOT NULL,
    `birthdate` DATE         NOT NULL,
    `biography` TEXT
);

INSERT INTO people(name, gender, birthdate)
VALUES ('Alexander Ivanov', 'm', '1970-01-01'),
       ('Bilyana Karamazova', 'f', '1980-11-11'),
       ('Chocho Popyordanov', 'm', '1990-05-16'),
       ('Daniela Stoyanova Colins', 'f', '1997-01-12'),
       ('Encho Kiryazov', 'm', '1979-07-22');