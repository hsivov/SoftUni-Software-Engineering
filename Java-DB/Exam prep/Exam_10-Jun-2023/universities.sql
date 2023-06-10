# 01. Table Design
CREATE DATABASE IF NOT EXISTS universities_db;
USE universities_db;

CREATE TABLE countries
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(40) NOT NULL UNIQUE,
    population INT,
    country_id INT         NOT NULL,
    CONSTRAINT fk_cities_countries
        FOREIGN KEY (country_id) REFERENCES countries (id)
);

CREATE TABLE universities
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(60)    NOT NULL UNIQUE,
    address         VARCHAR(80)    NOT NULL UNIQUE,
    tuition_fee     DECIMAL(19, 2) NOT NULL,
    number_of_staff INT,
    city_id         INT,
    CONSTRAINT fk_universities_cities
        FOREIGN KEY (city_id)
            REFERENCES cities (id)
);

CREATE TABLE students
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(40)  NOT NULL,
    last_name    VARCHAR(40)  NOT NULL,
    age          INT,
    phone        VARCHAR(20)  NOT NULL UNIQUE,
    email        VARCHAR(255) NOT NULL UNIQUE,
    is_graduated TINYINT(1)   NOT NULL,
    city_id      INT,
    CONSTRAINT fk_students_cities
        FOREIGN KEY (city_id)
            REFERENCES cities (id)
);

CREATE TABLE courses
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(40) NOT NULL UNIQUE,
    duration_hours DECIMAL(19, 2),
    start_date     DATE,
    teacher_name   VARCHAR(60) NOT NULL UNIQUE,
    description    TEXT,
    university_id  INT,
    CONSTRAINT fk_courses_universities
        FOREIGN KEY (university_id)
            REFERENCES universities (id)
);

CREATE TABLE students_courses
(
    grade      DECIMAL(19, 2) NOT NULL,
    student_id INT            NOT NULL,
    course_id  INT            NOT NULL,
    CONSTRAINT fk_sc_students
        FOREIGN KEY (student_id)
            REFERENCES students (id),
    CONSTRAINT fk_sc_courses
        FOREIGN KEY (course_id)
            REFERENCES courses (id)
);

# 02. Insert
INSERT INTO courses(name, duration_hours, start_date, teacher_name, description, university_id)
SELECT CONCAT(teacher_name, ' ', 'course'),
       LENGTH(name) / 10,
       DATE_ADD(start_date, INTERVAL 5 DAY),
       REVERSE(teacher_name),
       CONCAT('Course', ' ', teacher_name, REVERSE(description)),
       EXTRACT(DAY FROM start_date)
FROM courses
WHERE id <= 5;

# 03.Update
UPDATE universities
SET tuition_fee = tuition_fee + 300
WHERE id BETWEEN 5 AND 12;

# 04. Delete
DELETE u
FROM universities u
WHERE number_of_staff IS NULL;

# 05. Cities
SELECT *
FROM cities
ORDER BY population DESC;

# 06. Students age
SELECT first_name, last_name, age, phone, email
FROM students
WHERE age >= 21
ORDER BY first_name DESC, email, id
LIMIT 10;

# 07. New students
SELECT CONCAT(first_name, ' ', last_name) AS 'full_name',
       SUBSTRING(email, 2, 10)            AS 'username',
       REVERSE(phone)                     AS 'password'
FROM students
         LEFT JOIN students_courses sc ON students.id = sc.student_id
WHERE sc.course_id IS NULL
ORDER BY password DESC;

SET SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
# 08. Students count
SELECT COUNT(s.first_name) AS 'students_count',
       u.name              AS 'university_name'
FROM students s
         JOIN students_courses sc ON s.id = sc.student_id
         JOIN courses c ON c.id = sc.course_id
         JOIN universities u ON u.id = c.university_id
GROUP BY u.name
HAVING students_count >= 8
ORDER BY students_count DESC, u.name DESC;

# 09. Price rankings
SELECT u.name  AS 'university_name',
       c.name  AS 'city_name',
       address,
       CASE
           WHEN tuition_fee < 800 THEN 'cheap'
           WHEN tuition_fee BETWEEN 800 AND 1199 THEN 'normal'
           WHEN tuition_fee BETWEEN 1200 AND 2499 THEN 'high'
           WHEN tuition_fee >= 2500 THEN 'expensive'
           END AS 'price_rank',
       tuition_fee
FROM universities u
         JOIN cities c ON c.id = u.city_id
ORDER BY tuition_fee;

# 10. Average grades
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
BEGIN
    RETURN (SELECT AVG(sc.grade)
            FROM courses c
                     JOIN students_courses sc ON c.id = sc.course_id
                     JOIN students s ON s.id = sc.student_id
            WHERE c.name = course_name
              AND s.is_graduated = TRUE);
END;

SELECT c.name                                                     AS 'course_name',
       udf_average_alumni_grade_by_course_name('Quantum Physics') AS 'average_alumni_grade'
FROM courses c
WHERE c.name = 'Quantum Physics';

# 11. Graduate students
CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
BEGIN
    UPDATE students
        JOIN students_courses sc ON students.id = sc.student_id
        JOIN courses c ON c.id = sc.course_id
    SET is_graduated = TRUE
    WHERE EXTRACT(YEAR FROM start_date) = year_started;
END;

CALL udp_graduate_all_students_by_year(2017);

SELECT first_name, start_date, is_graduated
FROM students
         JOIN students_courses sc ON students.id = sc.student_id
         JOIN courses c ON c.id = sc.course_id
WHERE EXTRACT(YEAR FROM start_date) = 2017;