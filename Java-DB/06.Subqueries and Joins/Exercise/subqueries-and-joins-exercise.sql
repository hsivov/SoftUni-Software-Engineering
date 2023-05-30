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
# Write a query that selects:
# • employee_id
# • first_name
# Filter only employees without a project. Return the first 3 rows sorted by employee_id in descending order.

