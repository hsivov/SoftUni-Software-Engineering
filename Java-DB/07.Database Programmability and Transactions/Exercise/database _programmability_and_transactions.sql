USE soft_uni;
# 1. Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE salary > 35000
    ORDER BY first_name, last_name, employee_id;
END $$

DELIMITER ;
;

CALL usp_get_employees_salary_above_35000();

# 2. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(number DECIMAL(19, 4))
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE salary >= number
    ORDER BY first_name, last_name, employee_id;
END $$

DELIMITER ;
;

CALL usp_get_employees_salary_above(45000);

# 3. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(string varchar(50))
BEGIN
    SELECT name AS 'town_name'
    FROM towns
    WHERE name LIKE CONCAT(string, '%')
    ORDER BY town_name;
END $$

DELIMITER ;
;

CALL usp_get_towns_starting_with('B');

# 4. Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(string varchar(50))
BEGIN
    SELECT first_name, last_name
    FROM employees
             JOIN addresses a ON a.address_id = employees.address_id
             JOIN towns t ON t.town_id = a.town_id
    WHERE t.name LIKE string
    ORDER BY first_name, last_name, employee_id;
END $$

DELIMITER ;
;

CALL usp_get_employees_from_town('Sofia');

# 5. Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary INT)
    RETURNS varchar(7)
    DETERMINISTIC
BEGIN
    DECLARE result varchar(7);
    SET result :=
            (CASE
                 WHEN salary < 30000 THEN 'Low'
                 WHEN salary > 50000 THEN 'High'
                 ELSE 'Average'
                END);
    RETURN result;
END $$

DELIMITER ;
;

SELECT ufn_get_salary_level(50001) AS 'salary_level';

# 6. Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level varchar(7))
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE (
              CASE
                  WHEN salary_level = 'Low' THEN salary < 30000
                  WHEN salary_level = 'Average' THEN salary BETWEEN 30000 AND 50000
                  WHEN salary_level = 'High' THEN salary > 50000
                  END
              )
    ORDER BY first_name DESC, last_name DESC;
END$$

DELIMITER ;
;

CALL usp_get_employees_by_salary_level('High');

# 7. Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
    RETURNS bit
    DETERMINISTIC
BEGIN
    RETURN LOWER(word) REGEXP (CONCAT('^[', set_of_letters, ']+$'));
END$$

SELECT ufn_is_word_comprised('oistmiah', 'sofia');

# 8. Find Full Name
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT CONCAT(first_name, ' ', last_name) AS 'full_name'
    FROM account_holders
    ORDER BY full_name, id;
END $$

DELIMITER ;
;
CALL usp_get_holders_full_name();

# 9. People with Balance Higher Than
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(number DECIMAL(19, 4))
BEGIN
    SELECT first_name, last_name
    FROM account_holders ah
             JOIN accounts a ON ah.id = a.account_holder_id
    GROUP BY ah.id
    HAVING SUM(balance) > number
    ORDER BY ah.id;
END $$

DELIMITER ;
;
CALL usp_get_holders_with_balance_higher_than(7000);

# 10. Future Value Function
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4),
                                           yearly_interest_rate DECIMAL(4, 2),
                                           number_of_years int)
    RETURNS DECIMAL(19, 4)
    DETERMINISTIC
    RETURN sum * (POW(1 + yearly_interest_rate, number_of_years));

SELECT ufn_calculate_future_value(1000, 0.5, 5) AS 'Output';

# 11. Calculating Interest
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(5, 4))
BEGIN
    SELECT a.id,
           first_name,
           last_name,
           balance,
           (SELECT ufn_calculate_future_value(balance, interest_rate, 5)) AS 'balance_in_5_years'
    FROM account_holders ah
             JOIN accounts a ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END $$

DELIMITER ;
;

CALL usp_calculate_future_value_for_account(1, 0.1);

# 12 Deposit Money
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 THEN
        START TRANSACTION ;
        UPDATE accounts
        SET balance = balance + money_amount
        WHERE id = account_id;
    END IF;
END$$
DELIMITER ;
;
CALL usp_deposit_money(1, 10);

# 13. Withdraw Money
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 THEN
        START TRANSACTION;

        UPDATE accounts
        SET balance = balance - money_amount
        WHERE id = account_id;

        IF (SELECT balance FROM accounts WHERE id = account_id) < 0 THEN
            ROLLBACK;
        ELSE
            COMMIT ;
        END IF;
    END IF;
END $$

DELIMITER ;
;

CALL usp_withdraw_money(1, 10);

SELECT *
FROM accounts
WHERE id = 1;

# 14. Money Transfer
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
    IF amount > 0
        AND from_account_id != to_account_id
        AND (SELECT id FROM accounts WHERE id = from_account_id) IS NOT NULL
        AND (SELECT id FROM accounts WHERE id = to_account_id) IS NOT NULL
        AND (SELECT balance FROM accounts WHERE id = from_account_id) >= amount THEN

        START TRANSACTION;

        UPDATE accounts
        SET balance = balance - amount
        WHERE id = from_account_id;

        UPDATE accounts
        SET balance = balance + amount
        WHERE id = to_account_id;

    END IF;
END $$

DELIMITER ;
;
CALL usp_transfer_money(2, 1, 20);

SELECT id, balance
FROM accounts
WHERE id IN (1, 2);

# 15. Log Accounts Trigger
# Create another table – logs(log_id, account_id, old_sum, new_sum). Add a trigger to the accounts
# table that enters a new entry into the logs table every time the sum on an account changes.
CREATE TABLE logs
(
    log_id     INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    old_sum    DECIMAL(19, 4),
    new_sum    DECIMAL(19, 4)
);

CREATE TRIGGER accounts_after_update
    AFTER UPDATE
    ON accounts
    FOR EACH ROW

BEGIN
    INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END;

# 16. Emails Trigger
# Create another table – notification_emails(id, recipient, subject, body). Add a trigger to logs table
# to create new email whenever new record is inserted in logs table. The following data is required to be filled for
# each email:
# • recipient – account_id
# • subject – "Balance change for account: {account_id}"
# • body - "On {date (current date)} your balance was changed from {old} to {new}."
CREATE TABLE notification_emails
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT,
    subject   VARCHAR(100),
    body      TEXT
);

CREATE TRIGGER tr_notification_email
    AFTER INSERT
    ON logs
    FOR EACH ROW

BEGIN
    INSERT INTO notification_emails(recipient, subject, body)
    VALUES (
            NEW.account_id,
            CONCAT('Balance change for account: ', NEW.account_id),
            CONCAT_WS(' ', 'On', DATE_FORMAT(now(), '%b %d %Y at %r'), 'your balance was changed from', NEW.old_sum, 'to', NEW.new_sum, '.')
           );
END;