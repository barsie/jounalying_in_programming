""" This practice covers the implementation 
    of database in an ETL pipeline.
"""

# Import required dependencies
import pandas as pd
import sqlite3

# Create a db connection
conn = sqlite3.connect('STAFF.db')

# Load a table
table_name = 'INSTRUCTROR'
attribute_list = ['ID', 'FNAME', 'LNAME', 'CITY', 'CCODE']

# Read the CSV file
""" Since the CSV will not initially contain headers, 
    you can use the key of the attribute_dict as a list to assign headers
"""
# define the file path
file_path = "../databaseQuery/INSTRUCTOR.csv"

# read the csv file with pandas dataframe
df = pd.read_csv(file_path, names=attribute_list)

# Load data to the database table
# if the table existe raplace it

df.to_sql(table_name, conn, if_exists='replace', index='False')
print('Table alreade exist in the database, please replace it or make a copy of it.')

# Running basic queries on data
# SQL queries can be executed in pandas using the read_sql
query_statement = f"SELECT * FROM {table_name}"
query_output = pd.read_sql(query_statement, conn)
print(query_statement)
print(query_output)

# Query only FNAME of data fron the table INSTRUCTOR
query_statement = f"SELECT FNAME FROM {table_name}"
query_output = pd.read_sql(query_statement, conn)
print(query_statement)
print(query_output)

# Query the total number of entries in the table INSTRUCTOR
query_statement = f"SELECT COUNT(*) FROM {table_name}"
query_output = pd.read_sql(query_statement, conn)
print(query_statement)
print(query_output)

# Appending data to the table: using append.
data_dict = {
    "ID": [100],
    "FNAME": "Tomilav",
    "LNAME": "Douvlan",
    "CITY": "Varsovia",
    "CCODE": "VVIA"
}
data_append = pd.DataFrame(data_dict)
data_append.to_sql(table_name, conn, if_exists='append', index='False')
print("Data was appended successfully")

# closing connection to database 
conn.close()
