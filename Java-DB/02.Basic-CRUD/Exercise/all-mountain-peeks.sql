# 23
SELECT peak_name
FROM peaks;

# 22
SELECT country_name, population
FROM countries
WHERE continent_code = 'EU'
ORDER BY population DESC,
         country_name
LIMIT 30;

# 23
SELECT country_name, continent_code, if(currency_code = 'EUR', 'Euro', 'Not Euro') AS Currency
FROM countries
ORDER BY country_name;
