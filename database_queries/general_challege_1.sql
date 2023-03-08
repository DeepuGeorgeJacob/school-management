-- How many payment transactions were greater than $5.00?

SELECT count(amount) FROM payment WHERE amount>5;

-- How many actors have a first name that starts with the letter P?

SELECT count(first_name) FROM actor WHERE first_name LIKE 'P%';

-- How many unique districts are our customers from

SELECT COUNT(DISTINCT district) FROM address;

-- Retrive the list of non empty names for our customers from with alphabetical order

SELECT DISTINCT district FROM address WHERE district<>''  ORDER BY district ASC;

-- How many films have a rating of R and a replacement cost between $5 and $15?

SELECT count(title) FROM film WHERE rating='R' and replacement_cost BETWEEN 5 and 15;

-- How many films have the word Truman somewhere in the title?

SELECT COUNT(title) FROM film WHERE title LIKE '%Truman%';
