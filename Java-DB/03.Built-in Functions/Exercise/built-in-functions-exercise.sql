# Part I – Queries for SoftUni Database
# 1. Find Names of All Employees by First Name
USE soft_uni;

SELECT first_name, last_name
FROM employees
WHERE SUBSTRING(first_name, 1, 2) = 'Sa'
ORDER BY employee_id;

# 2. Find Names of All Employees by Last Name
SELECT first_name, last_name
FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

# 3. Find First Names of All Employees
SELECT first_name
FROM employees
WHERE (department_id = 3 OR department_id = 10)
  AND (YEAR(hire_date) BETWEEN 1995 AND 2005)
ORDER BY employee_id;

# 4. Find All Employees Except Engineers
SELECT first_name, last_name
FROM employees
WHERE job_title NOT LIKE '%engineer%'
ORDER BY employee_id;

# 05. Find Towns with Name Length
SELECT name
FROM towns
WHERE LENGTH(name) = 5
   OR LENGTH(name) = 6
ORDER BY name;

# 6. Find Towns Starting With
SELECT town_id, name
FROM towns
WHERE UPPER(name) LIKE 'M%'
   OR UPPER(name) LIKE 'K%'
   OR UPPER(name) LIKE 'B%'
   OR UPPER(name) LIKE 'E%'
ORDER BY name;

# 7. Find Towns Not Starting With
SELECT *
FROM towns
WHERE name REGEXP '^[^RrBbDd]'
ORDER BY name;

# 8. Create View Employees Hired After 2000 Year
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name
FROM employees
WHERE YEAR(hire_date) > 2000;

# 9. Length of Last Name
SELECT first_name, last_name
FROM employees
WHERE LENGTH(last_name) = 5;

# Part II – Queries for Geography Database
# 10. Countries Holding 'A' 3 or More Times

USE geography;
SELECT country_name, iso_code
FROM countries
WHERE CHAR_LENGTH(country_name) -
      CHAR_LENGTH(REPLACE(LOWER(country_name), 'a', '')) >= 3
# or easiest way LIKE '%a%a%a%'
ORDER BY iso_code;

# 11. Mix of Peak and River Names
SELECT peak_name,
       river_name,
       LOWER(CONCAT(LEFT(peak_name, LENGTH(peak_name) - 1), river_name)) AS mix
FROM peaks AS p,
     rivers AS r
WHERE UPPER(RIGHT(p.peak_name, 1) = LEFT(r.river_name, 1))
ORDER BY mix;

# Part III – Queries for Diablo Database
# 12. Games from 2011 and 2012 Year
USE diablo;
SELECT name, DATE_FORMAT(start, '%Y-%m-%d')
FROM games
WHERE YEAR(start) = 2011
   OR YEAR(start) = 2012
ORDER BY start, name
LIMIT 50;

# 13. User Email Providers
SELECT user_name,
       REGEXP_REPLACE(email, '.*@', '') AS 'email provider'
FROM users
ORDER BY `email provider`, user_name;

# 14. Get Users with IP Address Like Pattern
SELECT user_name, ip_address
FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

# 15. Show All Games with Duration and Part of the Day
SELECT name AS 'game',
       CASE
           WHEN HOUR(start) BETWEEN 0 AND 11 THEN 'Morning'
           WHEN HOUR(start) BETWEEN 12 AND 17 THEN 'Afternoon'
           ELSE 'Evening'
           END AS 'Part of the Day',
       CASE
           WHEN duration <= 3 THEN 'Extra Short'
           WHEN duration BETWEEN 4 AND 6 THEN 'Short'
           WHEN duration BETWEEN 7 AND 10 THEN 'Long'
           ELSE 'Extra Long'
           END AS 'Duration'

FROM games;

# Part IV – Date Functions Queries
# 16. Orders Table
USE orders;
SELECT
    product_name, order_date,
    DATE_ADD(order_date, INTERVAL 3 DAY ) AS pay_due,
    DATE_ADD(order_date, INTERVAL 1 MONTH ) AS deliver_due
    FROM orders;
