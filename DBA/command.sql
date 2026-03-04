-- Find the size of you tables in sql
SELECT 
    table_name AS "Table", 
    ROUND(((data_length + index_length) / 1024 / 1024), 2) AS "Size (MB)"
FROM 
    information_schema.tables
WHERE 
    table_schema = 'your_database_name' 
    AND table_name = 'billdata';

-- QUERY: to select all rows with a billedamount > 19999 in table billdata.
SELECT * FROM billdata WHERE billedamount > 19999;

-- Your customer wants to improve the execution time of the query you wrote
-- CREATE INDEX -- to improve the above query 
CREATE INDEX billed_index ON billdata(billedamount);

-- After creating the index, run the baseline query to find out if the index has any impact
-- The index should reduce the query execution time.

-- Verify if MySQL support MyISAM storage Engine
SHOW ENGINE;

-- Find the storage engines of billdata table
SHOW TABLE STATUS LIKE 'billdata'


-- Write a query to find out all the rows with a billing amount of 19929.

SELECT strftime("%Y-%m-%d %H:%M:%f", "now"); -- query to display the run time
SELECT * FROM billing WHERE billedamount = 19929;
SELECT strftime("%Y-%m-%d %H:%M:%f", "now"); -- query to display the run time

-- CREATE AN INDEX 
CREATE INDEX billed_index ON billing(billedamount);

-- TO DO

