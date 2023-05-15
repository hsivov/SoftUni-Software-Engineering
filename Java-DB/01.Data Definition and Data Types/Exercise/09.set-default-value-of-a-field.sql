ALTER TABLE minions.users
MODIFY COLUMN last_login_time datetime DEFAULT now();