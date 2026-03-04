# import required libraries
import requests
import pandas as pd
from datetime import datetime
from bs4 import BeautifulSoup
import numpy as np
import lxml
import sqlite3

# Code for ETL operations on Country-GDP data


# Function to log ETL process
def log_progress(message):
    '''This function logs the mentioned message of a given stage of the
    code execution to a log file. Function returns nothing'''

    timestamp_format = '%Y-%h-%d-%H:%M-%S'
    now = datetime.now()
    timestamp = now.strftime(timestamp_format)
    with open('./code_log.txt', 'a') as file:
        file.write(timestamp + ',' + message + '\n')


def extract(url, table_attribs):
    ''' This function aims to extract the required
    information from the website and save it to a data frame. The
    function returns the data frame for further processing. '''

    html_page = requests.get(url).text
    data = BeautifulSoup(html_page, 'html.parser')
    df = pd.DataFrame(columns=table_attribs)
    tables = data.find_all('tbody')
    rows = tables[0].find_all('tr')


    for row in rows:
        if row.find("td") is not None:
            col = row.find_all("td")
            bank_name = col[1].find_all('a')[1]['title']
            market_cap = col[2].contents[0][:-1]
            data_dict = {
                "Name": bank_name,
                "MC_USD_Billions": float(market_cap)
            }
            df1 = pd.DataFrame(data_dict, index=[0])
            df = pd.concat([df, df1], ignore_index=True)

    return df

def transform(df, csv_path):
    ''' This function accesses the CSV file for exchange rate
    information, and adds three columns to the data frame, each
    containing the transformed version of Market Cap column to
    respective currencies'''

    # Read the exchange file
    exchange_df = pd.read_csv(csv_path)

    # convert the enchange rate to dictionary: {Currency: Rate}
    exchange_rate = exchange_df.set_index(exchange_df.columns[0])[exchange_df.columns[1]].to_dict()

    # Add new column with converted market capitalization
    # Note: Data is already in USD, so no conversion needed for USD column
    df["MC_GBP_Billions"] = [np.round(x * exchange_rate['GBP'], 2) for x in df['MC_USD_Billions']]
    df["MC_EUR_Billions"] = [np.round(x * exchange_rate['EUR'], 2) for x in df['MC_USD_Billions']]

    return df

def load_to_csv(df, output_path):
    ''' This function saves the final data frame as a CSV file in
    the provided path. Function returns nothing.'''
    df.to_csv(output_path)

def load_to_db(df, sql_connection, table_name):
    ''' This function saves the final data frame to a database
    table with the provided name. Function returns nothing.'''
    df.to_sql(table_name, sql_connection, if_exists = 'replace', index = False)

def run_query(query_statement, sql_connection):
    ''' This function runs the query on the database table and
    prints the output on the terminal. Function returns nothing. '''

    print(query_statement)
    query_output = pd.read_sql(query_statement, sql_connection)
    print(query_output)


''' Here, you define the required entities and call the relevant
functions in the correct order to complete the project. Note that this
portion is not inside any function.'''

url = 'https://web.archive.org/web/20230908091635/https://en.wikipedia.org/wiki/List_of_largest_banks'
output_path = './CodingPython/pythonProjects/WebScraping/List_of_largest_banks.csv'
csv_path = './CodingPython/pythonProjects/WebScraping/exchange_rate.csv'
db_name = 'Banks.db'
table_name = "Largest_banks"
table_attribs = ["Name", "MC_USD_Billions", "MC_GBP_Billions", "MC_EUR_Billions"]

#  Log the initialization of the ETL process
log_progress("Preliminaries complete. Initializing ETL process")

# Logging the extaction process
df = extract(url, table_attribs)
log_progress("Data Extraction completed. Initiaiting Transformation process")

# Logging the transformation process
df = transform(df, csv_path)
log_progress("Transformation process completed. Initiating Loading process")

# Logging the loading process
load_to_csv(df, csv_path)
log_progress("Data saved to CSV file")

# Logging the sql connection to the database
sql_connection = sqlite3.connect('Banks.db')
log_progress("SQL initialization process")

load_to_db(df, sql_connection, table_name)
log_progress("Data loaded to database as table. Running the query")

query_statement = f"SELECT * FROM {table_name}"
run_query(query_statement, sql_connection)

query_statement = f"SELECT AVG(MC_GBP_Billions) FROM {table_name}"
run_query(query_statement, sql_connection)

query_statement = f'SELECT name FROM {table_name} LIMIT 5'
run_query(query_statement, sql_connection)

log_progress("Logging Process Completed")

sql_connection.close()