-- SELECT 

-- SELECT * FROM CUSTOMER;
-- SELECT first_name, last_name,email FROM CUSTOMER; 


-- SELECT DISTINCT

-- SELECT DISTINCT release_year FROM film;
-- SELECT DISTINCT (release_year) FROM film;
-- SELECT DISTINCT(rental_rate) FROM film;
-- Challenge
-- SELECT DISTINCT(rating) FROM film;

-- COUNT
-- SELECT amount FROM payment;
-- SELECT COUNT(*) FROM payment;
-- SELECT COUNT(amount) FROM payment;

-- SELECT DISTINCT amount FROM payment;
-- SELECT COUNT(DISTINCT amount) FROM payment;


-- SELECT WHERE

-- Syntax
-- SELECT column1,column2
-- FROM table
-- WHERE condition

-- SELECT * FROM CUSTOMER
-- WHERE first_name = 'Jared';


-- SELECT * FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating='R';
-- SELECT title FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating='R';
-- SELECT count(title) FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating='R';
-- SELECT count(*) FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating='R';
-- SELECT count(*) FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating='R' or rating='PG-13';
-- SELECT * FROM film WHERE rental_rate>4 AND replacement_cost>=19.99 AND rating<>'R';

-- Challenge Find nancy thomas email
-- SELECT email FROM customer WHERE first_name='Nancy' and last_name='Thomas';
-- Challenge - Find decrption of move 'African Egg'
-- SELECT description FROM film WHERE title='African Egg'
-- Challenge Find phone number of customer Who lived in 1531 Sal Drive
-- SELECT phone FROM address WHERE address='1531 Sal Drive'


-- ORDER BY

-- syntax

-- SELECT column_1,column_2, FROM table ORDER BY column_1 ASC/DESC

-- SELECT * FROM CUSTOMER ORDER BY first_name DESC;

-- SELECT store_id,first_name,last_name FROM CUSTOMER ORDER BY store_id,first_name;

-- SELECT store_id,first_name,last_name FROM CUSTOMER ORDER BY store_id DESC,first_name ASC

-- LIMIT
-- SELECT * FROM PAYMENT LIMIT 5;

-- SELECT * FROM PAYMENT 
-- WHERE amount<>0
-- ORDER BY payment_date DESC LIMIT 5;

-- Challenge 1: First 10 paying customers id
-- SELECT customer_id FROM payment ORDER BY payment_date ASC LIMIT 10

-- Challenge 2: Title of 5 shortest runtime movie 
-- SELECT title,length FROM FILM ORDER BY length ASC LIMIT 5;

-- -- How many shortest(50<) running movie available

-- SELECT title,length FROM film WHERE length<=50

-- BETWEEN and NOT BETWEEN

-- SELECT * FROM payment WHERE amount BETWEEN 8 AND 9;
-- SELECT * FROM payment WHERE amount NOT BETWEEN 8 AND 9;
-- SELECT * FROM payment WHERE payment_date BETWEEN '2007-02-01' AND '2007-02-15';
-- -- Nothing return
-- SELECT * FROM payment WHERE payment_date BETWEEN '2007-02-14' AND '2007-02-01'

-- IN

-- syntax
-- VALUE IN (option1,option1)

-- Example

-- SELECT color FROM table WHERE color IN ('Red','Blue')

-- SELECT DISTINCT(amount) FROM payment;

-- SELECT * FROM payment WHERE amount in (0.99,1.98,1.99)

-- SELECT * FROM payment WHERE amount NOT IN (0.99,1.98,1.99)

-- Question

-- SELECT * FROM customer WHERE first_name IN ('John','Jack','Julie')





