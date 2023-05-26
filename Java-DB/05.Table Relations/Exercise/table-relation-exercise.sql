# 1. One-To-One Relationship
CREATE TABLE people(
    person_id int UNIQUE NOT NULL AUTO_INCREMENT,
    first_name varchar(20) NOT NULL ,
    salary decimal(10 ,2) DEFAULT 0,
    passport_id int UNIQUE
);

CREATE TABLE passports(
    passport_id int PRIMARY KEY AUTO_INCREMENT,
    passport_number varchar(8) UNIQUE
);

ALTER TABLE people
ADD CONSTRAINT pk_people
PRIMARY KEY (person_id),
    ADD CONSTRAINT fk_people_passport
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);

INSERT INTO passports(passport_id, passport_number)
VALUES (101, 'N34FG21B'),
       (102, 'K65LO4R7'),
       (103, 'ZE657QP2');

INSERT INTO people(first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
       ('Tom', 56100.00, 103),
       ('Yana', 60200.00, 101);

# 2. One-To-Many Relationship
CREATE TABLE manufacturers
(
    manufacturer_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL ,
    established_on DATE
);

CREATE TABLE models(
    model_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20),
    manufacturer_id int,
    CONSTRAINT fk_models_manufacturer
                   FOREIGN KEY (manufacturer_id)
                   REFERENCES manufacturers (manufacturer_id)
);

INSERT INTO manufacturers(name, established_on)
    VALUES ('BMW', '1916-03-01'),
           ('Tesla', '2003-01-01'),
           ('Lada', '1966-05-01');

INSERT INTO models(model_id, name, manufacturer_id)
VALUES (101, 'X1', 1),
       (102, 'i6', 1),
       (103, 'Model S', 2),
       (104, 'Model X', 2),
       (105, 'Model 3', 2),
       (106, 'Nova', 3);

# 3. Many-To-Many Relationship
USE soft_uni;
CREATE TABLE students(
    student_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

INSERT INTO students(name)
VALUES ('Mila'),
       ('Toni'),
       ('Ron');

CREATE TABLE exams(
    exam_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

INSERT INTO exams(exam_id, name)
VALUES (101, 'Spring MVC'),
       (102, 'Neo4j'),
       (103, 'Oracle 11g');

CREATE TABLE students_exams(
    student_id int NOT NULL,
    exam_id int NOT NULL,
    CONSTRAINT pk_students_exams PRIMARY KEY (student_id, exam_id),
    CONSTRAINT fk_students_exams_students
                           FOREIGN KEY (student_id)
                           REFERENCES students(student_id),
                           CONSTRAINT fk_students_exams_exams
                           FOREIGN KEY (exam_id)
                           REFERENCES exams(exam_id)
);

INSERT INTO students_exams(student_id, exam_id)
VALUES (1, 101),
       (1, 102),
       (2, 101),
       (3, 103),
       (2, 102),
       (2, 103);

# 04. Self-Referencing
USE soft_uni;
CREATE TABLE teachers(
    teacher_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL ,
    manager_id int
);

INSERT INTO teachers(teacher_id, name, manager_id)
VALUES (101, 'John', NULL),
       (102, 'Maya', 106),
       (103, 'Silvia', 106),
       (104, 'Ted', 105),
       (105, 'Mark', 101),
       (106, 'Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_manager_id_teacher_id
FOREIGN KEY (manager_id)
REFERENCES teachers(teacher_id);

# 5. Online Store Database
CREATE TABLE item_types(
    item_type_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50)
);

CREATE TABLE items(
    item_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    item_type_id int,
    CONSTRAINT fk_items_item_types
                  FOREIGN KEY (item_type_id)
                  REFERENCES item_types(item_type_id)
);

CREATE TABLE cities(
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50)
);

CREATE TABLE customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    birthdate DATE,
    city_id INT,
    CONSTRAINT fk_customers_cities
                      FOREIGN KEY (city_id)
                      REFERENCES cities(city_id)
);

CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    CONSTRAINT fk_orders_customers
                   FOREIGN KEY (customer_id)
                   REFERENCES customers(customer_id)
);

CREATE TABLE order_items(
    order_id INT,
    item_id INT,
    CONSTRAINT pk_order_items
                        PRIMARY KEY (order_id, item_id),
                        CONSTRAINT fk_order_items_items
                        FOREIGN KEY (item_id)
                        REFERENCES items(item_id),
                        CONSTRAINT fk_order_items_orders
                        FOREIGN KEY (order_id)
                        REFERENCES orders(order_id)
);

# 6. University Database
CREATE TABLE subjects(
    subject_id int PRIMARY KEY AUTO_INCREMENT,
    subject_name varchar(50)
);

CREATE TABLE majors(
    major_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50)
);

CREATE TABLE students(
    student_id int PRIMARY KEY AUTO_INCREMENT,
    student_number varchar(12),
    student_name varchar(50),
    major_id int,
    CONSTRAINT fk_students_majors
                     FOREIGN KEY (major_id)
                     REFERENCES majors(major_id)
);

CREATE TABLE payments(
    payment_id int PRIMARY KEY AUTO_INCREMENT,
    payment_date date,
    payment_amount decimal (8, 2),
    student_id int,
    CONSTRAINT fk_payments_students
                     FOREIGN KEY (student_id)
                     REFERENCES students(student_id)
);

CREATE TABLE agenda(
    student_id int,
    subject_id int,
    CONSTRAINT pk_agenda PRIMARY KEY (student_id, subject_id),
    CONSTRAINT fk_agenda_students
                   FOREIGN KEY (student_id)
                   REFERENCES students(student_id),
                   CONSTRAINT fk_agenda_subject
                   FOREIGN KEY (subject_id)
                   REFERENCES subjects(subject_id)
);

# 9. Peaks in Rila
USE geography;
SELECT mountain_range, peak_name, elevation AS 'peak_elevation'
FROM mountains
JOIN peaks p ON mountains.id = p.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation DESC;
