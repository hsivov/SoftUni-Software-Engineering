CREATE DATABASE IF NOT EXISTS sgb;
USE sgb;

# 01. Table Design
CREATE TABLE addresses
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE categories
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE offices
(
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    workspace_capacity INT NOT NULL,
    website            VARCHAR(50),
    address_id         INT NOT NULL,
    CONSTRAINT fk_offices_addresses
        FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE employees
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(30)    NOT NULL,
    last_name       VARCHAR(30)    NOT NULL,
    age             INT            NOT NULL,
    salary          DECIMAL(10, 2) NOT NULL,
    job_title       VARCHAR(20)    NOT NULL,
    happiness_level CHAR           NOT NULL
);

CREATE TABLE teams
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(40) NOT NULL,
    office_id INT         NOT NULL,
    leader_id INT         NOT NULL UNIQUE,
    CONSTRAINT fk_teams_offices
        FOREIGN KEY (office_id) REFERENCES offices (id),
    CONSTRAINT fk_teams_employees
        FOREIGN KEY (leader_id) REFERENCES employees (id)
);

CREATE TABLE games
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(50)       NOT NULL UNIQUE,
    description  TEXT,
    rating       FLOAT DEFAULT 5.5 NOT NULL,
    budget       DECIMAL(10, 2)    NOT NULL,
    release_date DATE,
    team_id      INT               NOT NULL,
    CONSTRAINT fk_games_teams
        FOREIGN KEY (team_id) REFERENCES teams (id)
);

CREATE TABLE games_categories
(
    game_id     INT NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT pk_games_categories
        PRIMARY KEY (game_id, category_id),
    CONSTRAINT fk_gc_games
        FOREIGN KEY (game_id) REFERENCES games (id),
    CONSTRAINT fk_gc_categories
        FOREIGN KEY (category_id) REFERENCES categories (id)
);

# 02. Insert
INSERT INTO games(name, rating, budget, team_id)
SELECT REVERSE(SUBSTRING(LOWER(t.name), 2)), t.id, t.leader_id * 1000, t.id
FROM teams t
WHERE id BETWEEN 1 AND 9;

# 03. Update
UPDATE employees
SET salary = salary + 1000
WHERE age < 40
  AND salary < 5000;

# 04. Delete
DELETE g
FROM games g
         LEFT JOIN games_categories gc ON g.id = gc.game_id
WHERE category_id IS NULL
  AND release_date IS NULL;

# 05. Employees
SELECT first_name, last_name, age, salary, happiness_level
FROM employees
ORDER BY salary, id;

# 06. Addresses of the teams
SELECT t.name AS 'team_name',
       a.name AS 'address_name',
       LENGTH(a.name)
FROM teams t
         JOIN offices o ON o.id = t.office_id
         JOIN addresses a ON a.id = o.address_id
WHERE o.website IS NOT NULL
ORDER BY team_name, address_name;

# 07. Categories Info
SELECT c.name,
       COUNT(g.name)           AS 'games_count',
       ROUND(AVG(g.budget), 2) AS 'avg_budget',
       MAX(g.rating)           AS 'max_rating'
FROM categories c
         JOIN games_categories gc ON c.id = gc.category_id
         JOIN games g ON g.id = gc.game_id
GROUP BY c.name
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;

# 08. Games of 2022
SELECT g.name,
       g.release_date,
       CONCAT(LEFT(g.description, 10), '...') AS 'summary',
       CASE EXTRACT(MONTH FROM release_date)
           WHEN 1 THEN 'Q1'
           WHEN 2 THEN 'Q1'
           WHEN 3 THEN 'Q1'
           WHEN 4 THEN 'Q2'
           WHEN 5 THEN 'Q2'
           WHEN 6 THEN 'Q2'
           WHEN 7 THEN 'Q3'
           WHEN 8 THEN 'Q3'
           WHEN 9 THEN 'Q3'
           WHEN 10 THEN 'Q4'
           WHEN 11 THEN 'Q4'
           WHEN 12 THEN 'Q4'
           END                                AS 'quarter',
       t.name                                 AS 'team_name'
FROM games g
         JOIN teams t ON t.id = g.team_id
WHERE g.name LIKE '%2'
  AND EXTRACT(YEAR FROM release_date) = 2022
  AND EXTRACT(MONTH FROM release_date) MOD 2 = 0
ORDER BY quarter;

# 09. Full info for games
SELECT g.name,
       IF(budget < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
       t.name                                                     AS 'team_name',
       a.name                                                     AS 'address_name'
FROM games g
         LEFT JOIN games_categories gc ON g.id = gc.game_id
         JOIN teams t ON t.id = g.team_id
         JOIN offices o ON o.id = t.office_id
         JOIN addresses a ON a.id = o.address_id
WHERE release_date IS NULL
  AND category_id IS NULL
ORDER BY g.name;

# 10. Find all basic information for a game
CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    RETURN (SELECT CONCAT('The ', g.name, ' is developed by a ', t.name, ' in an office with an address ', a.name)
            FROM games g
                     JOIN teams t ON t.id = g.team_id
                     JOIN offices o ON o.id = t.office_id
                     JOIN addresses a ON a.id = o.address_id
            WHERE g.name = game_name);
END;

SELECT udf_game_info_by_name('Job') AS 'Info';

# 11. Update Budget of the Games
CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN
    UPDATE games g
        LEFT JOIN games_categories gc
        ON g.id = gc.game_id
    SET budget       = budget + 100000,
        release_date = DATE_ADD(release_date, INTERVAL 1 YEAR)
    WHERE gc.category_id IS NULL
      AND rating > min_game_rating
      AND release_date IS NOT NULL;
END;

CALL udp_update_budget(8);


SELECT g.name, budget, release_date
FROM games g
         LEFT JOIN games_categories gc ON g.id = gc.game_id
WHERE gc.category_id IS NULL
  AND rating > 8
  AND release_date IS NOT NULL;

