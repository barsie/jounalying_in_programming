# -*- coding: utf-8 -*-
"""
Write program to display your name and perform following operations on it: 
Display n characters from left. (Accept n as input from the user)
Count the number of vowels. 
Reverse it.
"""

"""we want to be able to print the last character of our name using the [] and 
indicating the index or slice (portion take)""" 

def name_test():
    
    name = input("Please add your name: ") # ask the user to input a name
    n = int(input("Introduce a number of characters: ")) # ask the use to input a number of desired characters
    
    print(f"First {n} characters of your name are '{name[:n]}'")
    
    #count the number of vowels
    vowels = 'aeiouAEIOU'
    
    #initialize the vowel count to 0
    count_vowels = 0
    
    for letter in name:
        if letter in vowels:
            count_vowels = count_vowels + 1
    print(f"Counted a total of {count_vowels} vowels in this name.")
    
    #reverse the counter 
    name_reversed = name[::-1]
    print(f"Revesed name count is: {name_reversed}")
    

name_test()
