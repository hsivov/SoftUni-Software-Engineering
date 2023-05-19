# 01
SELECT department_id, COUNT(*) AS 'Number of employees'
FROM employees
GROUP BY department_id
ORDER BY department_id;

# 02
SELECT
    department_id,
    ROUND(AVG(salary), 2) AS 'Average Salary'
FROM employees
GROUP BY department_id
ORDER BY department_id;

# 03
SELECT
    department_id,
    MIN(salary) AS 'Min Salary'
FROM employees
GROUP BY department_id
HAVING `Min Salary` > 800;

# 04
SELECT COUNT(*)
FROM products
WHERE category_id = 2 AND price > 8;

# 05.Menu Prices
SELECT category_id,
       ROUND(AVG(price), 2) AS 'Average Price',
       MIN(price) AS 'Cheapest Product',
       MAX(price) AS 'Most Expensive Product'
FROM products
GROUP BY category_id;