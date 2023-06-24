import mysql.connector

# Connect to the MySQL instance running in the container
connection = mysql.connector.connect(
    host='localhost',
    port='3306',
    user='root',
    password='password',
    database=''
)

# Create the database if it does not exist
create_database_query = "CREATE DATABASE IF NOT EXISTS datas"
cursor = connection.cursor()
cursor.execute(create_database_query)

# Use the database
use_database_query = "USE datas"
cursor.execute(use_database_query)

# Create the images table if it does not exist
create_table_query = "CREATE TABLE IF NOT EXISTS images (name VARCHAR(100), path VARCHAR(200))"
cursor.execute(create_table_query)

# insert fake data to init the database
insert_query = "INSERT INTO datas.images (name, path) VALUES (%s, %s)"
values = [
    ('image1', 'image1.jpg'),
    ('image2', 'image2.jpg'),
    ('image3', 'image3.jpg')
]
cursor.executemany(insert_query, values)

# Commit the changes and close the connection
connection.commit()
connection.close()

print("Database and table created successfully.")
