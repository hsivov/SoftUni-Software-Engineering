# 1. Managers
SELECT e.employee_id,
       CONCAT(first_name, ' ', last_name) AS 'full_name',
       d.department_id,
       name
FROM employees AS e
RIGHT JOIN departments d on e.employee_id = d.manager_id
ORDER BY employee_id
LIMIT 5;

# 2. Towns Addresses
SELECT towns.town_id,
       name AS 'town_name',
       address_text
FROM towns
JOIN addresses a ON towns.town_id = a.town_id
WHERE name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY town_id;

# 3. Employees Without Managers
SELECT employee_id, first_name, last_name, department_id, salary
FROM employees
WHERE manager_id is NULL;

# 4. Higher Salary
SELECT count(*) AS 'count'
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
    );
