# 1. Employee Address
SELECT employee_id, job_title, a.address_id, address_text
FROM employees
JOIN addresses a ON a.address_id = employees.address_id
ORDER BY address_id
LIMIT 5;

# 2. Addresses with Towns
SELECT first_name, last_name, t.name, address_text
FROM employees
JOIN addresses a ON a.address_id = employees.address_id
JOIN towns t ON t.town_id = a.town_id
ORDER BY first_name, last_name
LIMIT 5;

# 3. Sales Employee
SELECT employee_id, first_name, last_name, d.name
FROM employees
JOIN departments d ON d.department_id = employees.department_id
WHERE name = 'Sales'
ORDER BY employee_id DESC;

# 4. Employee Departments
SELECT employee_id, first_name, salary, d.name
FROM employees
JOIN departments d ON d.department_id = employees.department_id
WHERE salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

# 5. Employees Without Project
SELECT e.employee_id, first_name
FROM employees AS e
LEFT JOIN employees_projects ep ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

# 6. Employees Hired After
SELECT first_name, last_name, hire_date, d.name AS 'dept_name'
FROM employees
JOIN departments d ON employees.department_id = d.department_id
WHERE hire_date > '1999-01-01' AND d.name IN ('Sales', 'Finance')
ORDER BY hire_date;

# 7. Employees with Project
SELECT e.employee_id, first_name, p.name AS 'project_name'
FROM employees AS e
JOIN employees_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NULL
ORDER BY first_name, p.name
LIMIT 5;

# 8. Employee 24
SELECT e.employee_id, first_name, if(year(p.start_date) >= 2005, NULL, p.name) AS 'project_name'
FROM employees AS e
JOIN employees_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY p.name;

# 9. Employee Manager
SELECT e.employee_id, e.first_name, e.manager_id, m.first_name AS 'manager_name'
FROM employees e
JOIN employees m ON m.employee_id = e.manager_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;

# 10. Employee Summary
SELECT e.employee_id,
       CONCAT(e.first_name, ' ', e.last_name) AS 'employee_name',
       CONCAT(m.first_name, ' ', m.last_name) AS 'manager_name',
       d.name AS 'department_name'
FROM employees e
         JOIN employees m ON m.employee_id = e.manager_id
         JOIN departments d ON d.department_id = e.department_id
ORDER BY e.employee_id
LIMIT 5;

# 11. Min Average Salary
# Write a query that returns the value of the lowest average salary of all departments

SET SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

SELECT AVG(salary) AS 'min_average_salary'
FROM employees e
JOIN departments d ON d.department_id = e.department_id
GROUP BY e.department_id
ORDER BY min_average_salary
LIMIT 1;

