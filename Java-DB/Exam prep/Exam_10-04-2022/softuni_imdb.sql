CREATE DATABASE IF NOT EXISTS softuni_imdb;
USE softuni_imdb;

CREATE TABLE countries
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(30) NOT NULL UNIQUE,
    continent VARCHAR(30) NOT NULL,
    currency  varchar(5)  NOT NULL
);

CREATE TABLE genres
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE actors
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    birthdate  DATE        NOT NULL,
    height     INT,
    awards     INT,
    country_id INT,
    CONSTRAINT fk_actors_countries
        FOREIGN KEY (country_id)
            REFERENCES countries (id)
);

CREATE TABLE movies_additional_info
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    rating        DECIMAL(10, 2) NOT NULL,
    runtime       INT            NOT NULL,
    picture_url   VARCHAR(80)    NOT NULL,
    budget        DECIMAL(10, 2),
    release_date  DATE           NOT NULL,
    has_subtitles boolean,
    description   TEXT
);

CREATE TABLE movies
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(70) NOT NULL UNIQUE,
    country_id    INT         NOT NULL,
    movie_info_id INT         NOT NULL UNIQUE,
    CONSTRAINT fk_movies_countries
        FOREIGN KEY (country_id) REFERENCES countries (id)
);

CREATE TABLE movies_actors
(
    movie_id INT,
    actor_id INT,
    CONSTRAINT fk_ma_movie
        FOREIGN KEY (movie_id) REFERENCES movies (id),
    CONSTRAINT fk_ma_actors
        FOREIGN KEY (actor_id) REFERENCES actors (id)
);

CREATE TABLE genres_movies
(
    genre_id INT,
    movie_id INT,
    CONSTRAINT fk_gm_genres
        FOREIGN KEY (genre_id) REFERENCES genres (id),
    CONSTRAINT fk_gm_movies
        FOREIGN KEY (movie_id) REFERENCES movies (id)
);

# 02. Insert
INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT REVERSE(first_name),
       REVERSE(last_name),
       DATE(DATE(birthdate) - 2),
       height + 10,
       country_id,
       (SELECT id
        FROM countries
        WHERE name = 'Armenia')
FROM actors
WHERE id <= 10;

# 03. Update
UPDATE movies_additional_info
SET runtime = runtime - 10
WHERE id BETWEEN 15 AND 25;

# 04 Delete
DELETE c
FROM countries c
         LEFT JOIN movies m ON c.id = m.country_id
WHERE m.country_id IS NULL;

# 05. Countries
SELECT *
FROM countries
ORDER BY currency DESC, id;

# 06. Old movies
SELECT mai.id, title, runtime, budget, release_date
FROM movies_additional_info mai
         JOIN movies m ON m.movie_info_id = mai.id
WHERE release_date BETWEEN '1996-01-01' AND '1999-12-31'
ORDER BY runtime, id
LIMIT 20;

# 07. Movie casting
SELECT CONCAT(first_name, ' ', last_name)                         AS 'full_name',
       CONCAT(REVERSE(last_name), LENGTH(last_name), '@cast.com') AS 'email',
       2022 - EXTRACT(YEAR FROM birthdate)                        AS 'age',
       height
FROM actors
         LEFT JOIN movies_actors ma ON actors.id = ma.actor_id
WHERE ma.movie_id IS NULL
ORDER BY height;

# 08. International festival
SELECT c.name, COUNT(m.title) AS 'movies_count'
FROM countries c
         JOIN movies m ON c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY c.name DESC;

# 09 Rating system
SELECT title,
       IF(rating <= 4, 'poor',
          IF(rating <= 7, 'good', 'excellent')) AS 'rating',
       IF(has_subtitles, 'english', '-')        AS 'subtitles',
       budget
FROM movies m
         JOIN movies_additional_info mai ON m.movie_info_id = mai.id
ORDER BY budget DESC;

# 10. History movies
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE space_index INT;
    SET space_index := LOCATE(' ', full_name);
    RETURN (SELECT COUNT(g.name)
            FROM actors a
                     JOIN movies_actors ma ON a.id = ma.actor_id
                     JOIN genres_movies gm ON ma.movie_id = gm.movie_id
                     JOIN genres g ON g.id = gm.genre_id
            WHERE first_name = SUBSTRING(full_name, 1, space_index - 1)
              AND last_name = SUBSTRING(full_name, space_index + 1)
              AND g.name = 'History'
            GROUP BY a.id);
END;

SELECT udf_actor_history_movies_count('Stephan Lundberg') AS 'history_movies';

# 11. Movie awards
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
    UPDATE actors a
        JOIN movies_actors ma ON a.id = ma.actor_id
        JOIN movies m ON ma.movie_id = m.id
    SET awards = awards + 1
    WHERE title = movie_title;
END;

CALL udp_award_movie('Tea For Two');

SELECT CONCAT(first_name, ' ', last_name) AS 'full_name', awards
FROM actors
WHERE id IN (269, 88, 239);