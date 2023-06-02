USE soft_uni;

# 1. Count Employees by Town
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name varchar(50))
RETURNS int
DETERMINISTIC
BEGIN
    DECLARE e_count INT;
    SET e_count := (
        SELECT COUNT(*)
        FROM employees AS e
                 JOIN addresses a ON a.address_id = e.address_id
                 JOIN towns t ON t.town_id = a.town_id
        WHERE name = town_name
        );
    RETURN e_count;
END $$

DELIMITER ;
;

SELECT ufn_count_employees_by_town('Sofia');

# 2. Employees Promotion
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name varchar(50))
BEGIN
    UPDATE employees
        SET salary = salary * 1.05
    WHERE department_id = (SELECT department_id
                           FROM departments
                           WHERE name = department_name);
END $$

DELIMITER ;
;

CALL usp_raise_salaries('Tool Design');

SELECT first_name, salary
FROM employees;

# 3. Employees Promotion by ID
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id int)
BEGIN
    DECLARE employees_id_count int;
    SET employees_id_count := (SELECT COUNT(*) FROM employees WHERE employee_id = id);

    IF (employees_id_count = 1)
    THEN
    UPDATE employees
        SET salary = salary * 1.05
    WHERE employee_id = id;
    END IF;
END $$

DELIMITER ;
;

CALL usp_raise_salary_by_id(1);

SELECT employee_id, first_name, salary
FROM employees;


# 4. Triggered
# Create a table deleted_employees(employee_id PK,
# first_name,last_name,middle_name,job_title,deparment_id,salary) that will hold information
# about fired(deleted) employees from the employees table.
# Add a trigger to employees table that inserts the
# corresponding information in deleted_employees.
DELIMITER $$
CREATE TABLE deleted_employees(
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    middle_name varchar(50),
    job_title varchar(50),
    department_id INT,
    salary DECIMAL(19, 4)
);

CREATE TRIGGER tr_deleted_employees
    AFTER DELETE
    ON employees
    FOR EACH ROW
    BEGIN
        INSERT INTO deleted_employees(first_name, last_name, middle_name, job_title, department_id, salary)
        VALUES (OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title,
                OLD.department_id, OLD.salary);
    END $$

DELIMITER ;
;

DELETE FROM employees WHERE employee_id IN (1);

SELECT * FROM deleted_employees;