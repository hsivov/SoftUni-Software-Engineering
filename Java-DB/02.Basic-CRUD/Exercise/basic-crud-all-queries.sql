# 01
USE soft_uni;

SELECT * FROM departments ORDER BY department_id;

# 02
SELECT name FROM departments
ORDER BY department_id;

# 03
SELECT first_name, last_name, salary
FROM employees
ORDER BY employee_id;

# 04
SELECT first_name, middle_name, last_name
FROM employees
ORDER BY employee_id;

# 05
SELECT CONCAT(first_name, '.', last_name, '@softuni.bg') AS full_email_address
FROM employees;

# 06
SELECT DISTINCT salary
FROM employees;

# 07
SELECT *
FROM employees
WHERE job_title = 'Sales Representative'
ORDER BY employee_id;

# 08
SELECT first_name, last_name, job_title
FROM employees
WHERE salary BETWEEN 20000 AND 30000
ORDER BY employee_id;

# 09
SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS 'Full Name'
FROM employees
WHERE salary IN (25000, 14000, 14000, 23600);

# 10
SELECT first_name, last_name
FROM employees
WHERE manager_id IS NULL;

# 11
SELECT first_name, last_name, salary
FROM employees
WHERE salary > 50000
ORDER BY salary DESC;

# 12
SELECT first_name, last_name
FROM employees
ORDER BY salary DESC
LIMIT 5;

# 13
SELECT first_name, last_name
FROM employees
WHERE NOT department_id = 4;

# 14
SELECT *
FROM employees
ORDER BY salary DESC,
         first_name,
         last_name DESC,
         middle_name;

# 15
CREATE VIEW v_employees_salaries AS
SELECT first_name, last_name, salary
FROM employees;

# 16
CREATE VIEW v_employees_job_titles AS
SELECT concat_ws(' ', first_name, middle_name, last_name) AS full_name,
       job_title
FROM employees;

# 17
SELECT DISTINCT job_title
FROM employees
ORDER BY job_title;

# 18
SELECT *
FROM projects
ORDER BY start_date,
         name LIMIT 10;

# 19
SELECT first_name, last_name, hire_date
FROM employees
ORDER BY hire_date DESC
LIMIT 7;

# 20
UPDATE employees
SET salary = salary * 1.12
WHERE department_id IN (1, 2, 4, 11);

SELECT salary
FROM employees;
