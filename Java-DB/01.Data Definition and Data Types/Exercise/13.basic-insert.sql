/* Now create bigger database called soft_uni. You will use database in the future tasks. It should hold information
about
 • towns (id, name)
 • addresses (id, address_text, town_id)
 • departments (id, name)
 • employees (id, first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)
Id columns are auto incremented starting from 1 and increased by 1 (1, 2, 3, 4…). Make sure you use appropriate
data types for each column. Add primary and foreign keys as constraints for each table. Use only SQL queries.
Consider which fields are always required and which are optional.
Do not submit creation of database only the insert statements.
Use the SoftUni database and insert some data using SQL queries.

   towns: Sofia, Plovdiv, Varna, Burgas */

CREATE TABLE towns
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

INSERT INTO towns(name)
VALUES ('Sofia'),
       ('Plovdiv'),
       ('Varna'),
       ('Burgas');

# departments: Engineering, Sales, Marketing, Software Development, Quality Assurance
CREATE TABLE departments
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

INSERT INTO departments(name)
VALUES ('Engineering'),
       ('Sales'),
       ('Marketing'),
       ('Software Development'),
       ('Quality Assurance');

CREATE TABLE addresses(
    id int PRIMARY KEY AUTO_INCREMENT,
    address_text varchar(50),
    town_id int,
    FOREIGN KEY (town_id) REFERENCES towns(id)
);

#employees (id, first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)

CREATE TABLE employees(
    id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(15),
    middle_name varchar(15),
    last_name varchar(15),
    job_title varchar(20),
    department_id int,
    hire_date date,
    salary double(7, 2),
    address_id int,
    FOREIGN KEY (department_id) REFERENCES departments(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

INSERT INTO employees(first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.Net Developer', (SELECT departments.id FROM departments
                                                                  WHERE name='Software Development'), '2013-02-01',
        3500.00),
       ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', (SELECT `id`
                                                         FROM departments
                                                         WHERE `name` = 'Engineering'), '2004-03-02', 4000.00),
       ('Maria', 'Petrova', 'Ivanova', 'Intern', (SELECT `id`
                                                  FROM departments
                                                  WHERE `name` = 'Quality Assurance'), '2016-08-28', 525.25),
       ('Georgi', 'Terziev', 'Ivanov', 'CEO', (SELECT `id`
                                               FROM departments
                                               WHERE `name` = 'Sales'), '2007-12-09', 3000.00),
       ('Peter', 'Pan', 'Pan', 'Intern', (SELECT `id`
                                          FROM departments
                                          WHERE `name` = 'Marketing'), '2016-08-28', 599.88);
