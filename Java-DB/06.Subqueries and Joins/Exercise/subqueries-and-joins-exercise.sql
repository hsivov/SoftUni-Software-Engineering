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

# 12. Highest Peaks in Bulgaria
USE geography;
SELECT c.country_code, mountain_range, peak_name, elevation
FROM mountains m
LEFT JOIN mountains_countries mc ON m.id = mc.mountain_id
JOIN countries c ON c.country_code = mc.country_code
JOIN peaks p ON m.id = p.mountain_id
WHERE c.country_code = 'BG' AND elevation > 2835
ORDER BY elevation DESC;

# 13. Count Mountain Ranges
SELECT c.country_code, COUNT(mountain_range) AS 'mountain_range'
FROM mountains m
LEFT JOIN mountains_countries mc ON m.id = mc.mountain_id
JOIN countries c ON c.country_code = mc.country_code
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY mountain_range DESC;

# 14. Countries with Rivers
SELECT country_name, river_name
FROM countries
LEFT JOIN countries_rivers cr ON countries.country_code = cr.country_code
    LEFT JOIN rivers r ON r.id = cr.river_id
JOIN continents c ON c.continent_code = countries.continent_code
WHERE continent_name = 'Africa'
ORDER BY country_name
LIMIT 5;

# 15. *Continents and Currencies
SELECT c.continent_code, c.currency_code, COUNT(*) AS 'currency_usage'
FROM countries AS c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage > 1
   AND currency_usage = (SELECT COUNT(*) AS 'count_of_currencies'
                         FROM countries c2
                         WHERE c2.continent_code = c.continent_code
                         GROUP BY c2.currency_code
                         ORDER BY count_of_currencies DESC
                         LIMIT 1
                         )
ORDER BY c.continent_code, c.currency_code;

# 16. Countries Without Any Mountains
# Find the count of all countries which don't have a mountain
SELECT count(*) AS 'country_count'
FROM countries
LEFT JOIN mountains_countries mc ON countries.country_code = mc.country_code
WHERE mountain_id IS NULL;

# 17. Highest Peak and Longest River by Country
# For each country, find the elevation of the highest peak and the length of the longest river, sorted by the highest
# peak_elevation (from highest to lowest), then by the longest river_length (from longest to smallest), then
# by country_name (alphabetically). Display NULL when no data is available in some of the columns. Limit only the
# first 5 rows
SELECT country_name, MAX(elevation) AS 'highest_peak_elevation', MAX(length) AS 'longest_river_length'
FROM countries
JOIN mountains_countries mc ON countries.country_code = mc.country_code
    JOIN countries_rivers cr ON countries.country_code = cr.country_code
    JOIN rivers r ON r.id = cr.river_id
    JOIN peaks p ON mc.mountain_id = p.mountain_id
GROUP BY country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, country_name
LIMIT 5;