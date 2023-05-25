# 01
CREATE TABLE mountains
(
    id   int AUTO_INCREMENT NOT NULL,
    name varchar(50)        NOT NULL,
    CONSTRAINT pk_mountains PRIMARY KEY (id)
);

CREATE TABLE peaks
(
    id           int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name         varchar(50)                    NOT NULL,
    mountains_id int                            NOT NULL,
    CONSTRAINT fk_peaks_mountains_id_mountains_id
        FOREIGN KEY (mountains_id)
            REFERENCES mountains (id)
);

INSERT INTO mountains(name)
VALUES ('Rila'),
       ('Pirin');

INSERT INTO peaks(name, mountains_id)
VALUES ('Musala', 1),
       ('Vihren', 2);

SELECT peaks.id, peaks.name, mountains.name
FROM peaks
         JOIN mountains ON peaks.mountains_id = mountains.id;

# 02
SELECT driver_id,
       vehicle_type,
       CONCAT(first_name, ' ', last_name) AS 'driver_name'
FROM vehicles
         JOIN campers ON driver_id = campers.id;

# 03
SELECT starting_point,
       end_point,
       CONCAT(first_name, ' ', last_name) AS 'leader_name'
FROM routes JOIN campers c ON c.id = routes.leader_id;

# 04
DROP TABLE peaks;
DROP TABLE mountains;

CREATE TABLE mountains
(
    id   int AUTO_INCREMENT NOT NULL,
    name varchar(50)        NOT NULL,
    CONSTRAINT pk_mountains PRIMARY KEY (id)
);

CREATE TABLE peaks
(
    id           int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name         varchar(50)                    NOT NULL,
    mountains_id int                            NOT NULL,
    CONSTRAINT fk_peaks_mountains_id_mountains_id
        FOREIGN KEY (mountains_id)
            REFERENCES mountains (id)
            ON DELETE CASCADE
);

INSERT INTO mountains(name)
VALUES ('Rila'),
       ('Pirin');

INSERT INTO peaks(name, mountains_id)
VALUES ('Musala', 1),
       ('Vihren', 2);

SELECT * FROM mountains;
DELETE FROM mountains WHERE mountains.id = 1;

SELECT * FROM peaks;
