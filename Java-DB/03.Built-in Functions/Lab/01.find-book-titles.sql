SELECT title
FROM books
WHERE substring(title, 1, 3) = 'The'
ORDER BY id;
