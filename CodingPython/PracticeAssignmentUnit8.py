"""
# Traversing all the branch of a specified path
for(root,dirs,files) in os.walk('B:/Freelance/testPython', topdown=True):
    print("Directory Path: %s" %root)
    print("Directory Names: %s" %dirs)
    print("File Names: %s" %files)
"""

import os



"""
file = open('somthing')

print(file)

file = open('/etc/passwd', 'w')

print(file)


try:
    file = input('Introdroduce your file: ')
    file = open('test_python.py')
    print(file)
except:
    print('Not a file or directory, please try a valid file or directory')
"""



file = input('Introdroduce your file: ')
x = open(file)
print(x)

try:
    with open("nonexistent_file.txt", "r") as file:
        content = file.read()
    print(content)
except FileNotFoundError:
    print("Error: The specified file was not found.")
