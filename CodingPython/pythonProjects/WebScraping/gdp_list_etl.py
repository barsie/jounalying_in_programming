# import required libraries
import pandas as pd
from bs4 import BeautifulSoup
from datetime import datetime
import numpy as np
import sqlite3
import requests

# Code for ETL operations on Country-GDP data

def extract(url, table_attribs):
    ''' This function extracts the required
    information from the website and saves it to a dataframe. The
    function returns the dataframe for further processing. '''

    # Loading the webpage for webscriping
    html_page = requests.get(url).text #extract the data from webpage as text
    data = BeautifulSoup(html_page, 'html.parser') # parsing page data into an html object
    df = pd.DataFrame(columns=table_attribs) # Create and empty DataFrame

    # Scraping of required information
    tables = data.find_all("tbody") # extract all tbody attributes

    #Extract all rows attributes: note that the data to be extacted it is at index 2 from the table in the url
    rows = tables[2].find_all("tr") 

    for row in rows:
        col = row.find_all('td') #check the content of each row having having 'td'
        if len(col) != 0:
            if col[0].find('a') is not None and '—' not in col[2]: # verify that the second column does not contain a —
                data_dict = {
                    "Country": col[0].a.contents[0],
                    "GDP_USD_Millions": col[2].contents[0],
                }
                df1 = pd.DataFrame(data_dict, index=[0])
                df = pd.concat([df, df1], ignore_index=True) 
    
    return df

def transform(df):
    ''' This function converts the GDP information from Currency
    format to float value, transforms the information of GDP from
    USD (Millions) to USD (Billions) rounding to 2 decimal places.
    The function returns the transformed dataframe.'''

    GDP_list = df["GDP_USD_Millions"].tolist() # save the dataframe column GDP_USD_Millions into a list

    # iterate over the content of the list, convert the currency into numerical text using split() and join()
    # typecast the numerical text to float
    GDP_list = [float("".join(x.split(','))) for x in GDP_list]

    # Convert the GDP from millions to billions. Rounding up the values using numpy
    GDP_list = [np.round(x/1000, 2) for x in GDP_list]

    # Assign the modified list back to the dataframe
    df['GDP_USD_Millions'] = GDP_list 

    # Modified the name of the column from GDP_USD_Millions to GDP_USD_Billions
    df = df.rename(columns= {"GDP_USD_Millions":"GDP_USD_Billions"})

    return df

def load_to_csv(df, csv_path):
    ''' This function saves the final dataframe as a `CSV` file 
    in the provided path. Function returns nothing.'''
    
    df.to_csv(csv_path)

def load_to_db(df, sql_connection, table_name):
    ''' This function saves the final dataframe as a database table
    with the provided name. Function returns nothing.'''

    df.to_sql(table_name, sql_connection, if_exists='replace', index = False)

def run_query(query_statement, sql_connection):
    ''' This function runs the stated query on the database table and
    prints the output on the terminal. Function returns nothing. '''

    print(query_statement)
    query_output = pd.read_sql(query_statement, sql_connection)
    print(query_output)

def log_progress(message):
    ''' This function logs the mentioned message at a given stage of the code execution to a log file. Function returns nothing'''
    timestamp_format = "%Y-%h-%d-%H:%M:%S"
    now = datetime.now() # get current time
    timestamp = now.strftime(timestamp_format)
    with open("./gdp_etl_log.txt", "a") as file:
        file.write(timestamp + ',' + message + '\n')

''' Here, you define the required entities and call the relevant 
functions in the correct order to complete the project. Note that this
portion is not inside any function.'''

# Initialize know entities

url = 'https://web.archive.org/web/20230902185326/https://en.wikipedia.org/wiki/List_of_countries_by_GDP_%28nominal%29'
db_name = 'World_Economies.db'
table_name = 'Countries_by_GDP'
csv_path = '../WebScraping/Countries_by_GDP.csv'
table_attribs = ['Country', 'GDP_USD_Millions']

#  Log the initialization of the ETL process
log_progress("Preliminaries complete. Initializing ETL process")

# Logging the extaction process
df = extract(url, table_attribs)
log_progress("Data Extraction completed. Initiaiting Transformation process")

# Logging the transformation process
df = transform(df)
log_progress("Transformation process completed. Initiating Loading process")

# Logging the loading process
load_to_csv(df, csv_path)
log_progress("Data saved to CSV file")

# Logging the sql connection to the database
sql_connection = sqlite3.connect('World_Economies.db')
log_progress("SQL initialization process")

load_to_db(df, sql_connection, table_name)
log_progress("Data loaded to database as table. Running the query")

query_statement = f"SELECT * from {table_name} WHERE GDP_USD_Billions >= 100"
run_query(query_statement, sql_connection)

log_progress("Logging Process Completed")

sql_connection.close()