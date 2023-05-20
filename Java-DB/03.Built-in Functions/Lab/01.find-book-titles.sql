SELECT title
FROM books
WHERE substring(title, 1, 3) = 'The'
ORDER BY id;

SELECT
    concat_ws(' ', first_name, last_name) AS 'Full Name',
    TIMESTAMPDIFF(DAY, born, died) AS 'Day Lived'
FROM authors;