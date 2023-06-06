CREATE DATABASE IF NOT EXISTS restaurant_db;
USE restaurant_db;

# 01.Table Design
CREATE TABLE products
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  varchar(30)    NOT NULL UNIQUE,
    type  varchar(30)    NOT NULL,
    price decimal(10, 2) NOT NULL
);

CREATE TABLE clients
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    birthdate  DATE        NOT NULL,
    card       VARCHAR(50),
    review     TEXT
);

CREATE TABLE tables
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    floor    INT NOT NULL,
    reserved boolean,
    capacity INT NOT NULL
);

CREATE TABLE waiters
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    phone      VARCHAR(50),
    salary     DECIMAL(10, 2)
);

CREATE TABLE orders
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    table_id     INT  NOT NULL,
    waiter_id    INT  NOT NULL,
    order_time   TIME NOT NULL,
    payed_status BOOLEAN,
    CONSTRAINT fk_orders_tables
        FOREIGN KEY (table_id) REFERENCES tables (id),
    CONSTRAINT fk_orders_waiters
        FOREIGN KEY (waiter_id) REFERENCES waiters (id)
);

CREATE TABLE orders_clients
(
    order_id  INT,
    client_id INT,
    CONSTRAINT fk_oc_orders
        FOREIGN KEY (order_id)
            REFERENCES orders (id),
    CONSTRAINT fk_oc_clients
        FOREIGN KEY (client_id)
            REFERENCES clients (id)
);

CREATE TABLE orders_products
(
    order_id   INT,
    product_id INT,
    CONSTRAINT fk_op_orders
        FOREIGN KEY (order_id)
            REFERENCES orders (id),
    CONSTRAINT fk_op_products
        FOREIGN KEY (product_id)
            REFERENCES products (id)
);

# 02. Insert
INSERT INTO products(name, type, price)
SELECT CONCAT(w.last_name, ' ', 'specialty'), 'Cocktail', CEIL(w.salary * 0.01)
FROM waiters AS w
WHERE id > 6;

# 03. Update
UPDATE orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;

# 04. Delete
DELETE w
FROM waiters w
         LEFT JOIN orders o ON w.id = o.waiter_id
WHERE o.id IS NULL;

# 05. Clients
SELECT *
FROM clients
ORDER BY birthdate DESC, id DESC;

# 06. Birthdate
SELECT first_name, last_name, birthdate, review
FROM clients
WHERE card IS NULL
  AND birthdate BETWEEN '1978-01-01' AND '1993-12-31'
ORDER BY last_name DESC, id
LIMIT 5;

# 07. Accounts
SELECT CONCAT(last_name, first_name, LENGTH(first_name), 'Restaurant') AS 'username',
       REVERSE(SUBSTRING(email, 2, 12))                                AS 'password'
FROM waiters
WHERE salary IS NOT NULL
ORDER BY password DESC;

SET SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
# 08. Top from menu
SELECT p.id, p.name, COUNT(order_id) AS 'count'
FROM products p
         JOIN orders_products op ON p.id = op.product_id
GROUP BY p.name
HAVING count >= 5
ORDER BY count DESC, p.name;

# 09. Availability
# Write a query that returns the table_id, capacity, count_clients  and availability of all tables from the 1st floor.
# Count_clients is the number of people from all orders that are sitting on that table.
# Availability is based on how many people are sitting and the capacity of the table.
# If the capacity is greater than count_clients than it should be "Free seats",
# if the capacity is equal to the count_clients it should be "Full",
# and if the capacity is lower than the count_clients it should be "Extra seats".
# Order the results descending by table_id.
SELECT tables.id,
       capacity,
       COUNT(oc.client_id)   AS 'count_clients',
       IF(capacity > COUNT(oc.client_id), 'Free seats',
          IF(capacity = COUNT(oc.client_id), 'Full',
             'Extra seats')) AS 'availability'
FROM tables
         JOIN orders o ON tables.id = o.table_id
         JOIN orders_clients oc ON o.id = oc.order_id
WHERE floor = 1
GROUP BY tables.id
ORDER BY tables.id DESC;

# 10. Extract bill
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
BEGIN
    DECLARE space_index INT;
    SET space_index := LOCATE(' ', full_name);
    RETURN
        (SELECT SUM(p.price) AS 'bill'
         FROM clients
                  JOIN orders_clients oc ON clients.id = oc.client_id
                  JOIN orders_products op ON oc.order_id = op.order_id
                  JOIN products p ON op.product_id = p.id
         WHERE first_name = SUBSTRING(full_name, 1, space_index - 1) AND
               last_name = SUBSTRING(full_name, space_index + 1)
         );
END;

SELECT c.first_name, c.last_name, udf_client_bill('Silvio Blyth') AS 'bill'
FROM clients c
WHERE first_name = 'Silvio' AND last_name = 'Blyth';

#  11. Happy hour
CREATE PROCEDURE udp_happy_hour(product_type VARCHAR(50))
BEGIN
    UPDATE products p
    SET price = price * 0.8
    WHERE price >= 10 AND p.type = product_type;
END;

CALL udp_happy_hour('Cognac');
