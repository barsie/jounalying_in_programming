# import required packages
import glob
import pandas as pd 
import xml.etree.ElementTree as ET
from datetime import datetime as dt

# Initialized global variables to hold data output

log_file = "log_file.txt"
target_file = "target_file.txt"

# Extract function for csv file
def extract_from_csv(file_to_process):
    df = pd.read_csv(file_to_process)
    return df

# Extract function for json file
def extract_from_json(file_to_process):
    df = pd.read_json(file_to_process, lines=True)
    return df

# Extract and Parse xml function
def extract_from_xml(file_to_process):
    df = pd.DataFrame(columns=["car_model", "year_of_manufacture", "fuel", "price"])
    tree = ET.parse(file_to_process)
    root = tree.getroot()
    for car in root:
        car_model = car.find("car_model").text
        year_of_manufacture = car.find("year_of_manufacture").text
        fuel = car.find("fuel").text
        price = car.find("price").text

        # concatenate extracted columns
        df = pd.concat([df, pd.DataFrame([{"car_model": car_model, "year_of_manufacture": year_of_manufacture, "fuel": fuel, "price": price}])])

    return df

# Function to identify the file type
def extract():
    extracted_data = pd.DataFrame(columns=['car_model', 'year_of_manufacture', 'fuel', 'price']) # create an empty data frame to hold extracted data
    
    # process all csv file, except the target file
    for csvfile in glob.glob("*.csv"):
        if csvfile != target_file:
            extracted_data = pd.concat([extracted_data, pd.DataFrame(extract_from_csv(csvfile))], ignore_index=True)
    
    # process all json files
    for jsonfile in glob.glob("*.json"):
        extracted_data = pd.concat([extracted_data, pd.DataFrame(extract_from_json(jsonfile))], ignore_index=True)
    
    # process all xml files
    for xmlfile in glob.glob("*.xml"):
        extracted_data = pd.concat([extracted_data, pd.DataFrame(extract_from_xml(xmlfile))], ignore_index=True)

    return extracted_data

#  -------------------------- TRANSFORM SECTION --------------------------

def transform(data):
    '''
    Convert price so that they are rounded to 2 decimals. Ex 123.33
    '''
    data = data.copy()
    data['price'] = pd.to_numeric(data['price'], errors='coerce').round(2)

    return data

# -------------------------- LOAD SECTION ------------------------------

#  Loading and Logging Function
def load_data(target_file, transformed_data):
    transformed_data.to_csv(target_file)

# Loging loading progress
def log_progress(message):
    timestamp_format = "%Y-%h-%d-%H:%M:%S" # Year-Monthname-Day-Hour-Minute-Second
    now = dt.now() # get current timestamp
    timestamp = now.strftime(timestamp_format)
    with open(log_file, "a") as file:
        file.write(timestamp + ',' + message + '\n')
    
# Log the initialization of the ETL process
log_progress("ETL Job Started")

# Log the beginning of the Extraction process
log_progress("Extract phase Started")
extracted_data = extract()

# Log the completion of the Extraction process
log_progress("Extract phase Ended")

# Log the biginning of the Transform process
log_progress("Transform phase Started")
transformed_data = transform(extracted_data)
print("Transformed Data")
print(transformed_data)

# Log the completion of the Transformation process
log_progress("Transform phase Ended")

# Log the biginning of the Loading process
log_progress("Load phase Started")
load_data(target_file, transformed_data)

# Log the completion of the Loading process
log_progress("Load phase Ended")

# Log the completion of the ETL process
log_progress("ETL Job Ended")
