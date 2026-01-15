# -*- coding: utf-8 -*-
"""
Part 1 

You work as a software developer in a company that creates custom software solutions 
for various clients. Your company has been approached by an educational client who wants 
to develop a function that calculates the length of the hypotenuse of a right triangle given 
the lengths of the other two legs as arguments. Your manager has instructed you to use 
incremental development to create the necessary function and document each stage of the 
development process. After completing the final stage of development, you have to test the 
function with different arguments and record the outputs in your Learning Journal. 

"""

""" 
Triangle hypethenus formula: h = sqr(length1**2 + length2**2)
1. Tempting to calculate the length with a temporary variables given (b and c)
2. Use another termporary variable to calculate the hypothenus given (h)
3. Declare two variables and assign them a temporal values
4. First calculate the length, which is length = (length1**2 + length2**2)
5. Import the math build in function
6. Use the sqrt() method to calculate the hypothenus given priviously 
calculated length, h = math.sqrt(length)
7. Use a print to output the results
"""

import math #import math to use the sqrt() build in function
c = 3 
b = 4 
length = b**2 + c**2 
h = math.sqrt(length) 
print(h)

"""
How this works:
    - b**2 when b = 4 result is 16
    - c**2 when c = 3 result is 9
    - length = 16 + 5 result is 25
    - h = sqrt(length) result is 5

Seems like whe have accomplished the requirement, now we can encapsulate all the
code in a function:
    - Let's call it tringle and pass it three paremeters (b, c)
    - return 0
    - and call the function with differents argument to see if it works
"""  

def triangle(b, c):
    return 0 

triangle(3, 4)

# result here is 0 and will always be, independently of provided arguments

""" Apply encapsulation:""" 

def triangle(b, c):
    c = 3 
    b = 4 
    length = b**2 + c**2 
    h = math.sqrt(length) 
    print(h)
    
triangle( 3, 4 )

""" 
Fine-tuning:
    - c and b temporal variables are no longer necessary
"""

def triangle(b, c):
    length = b**2 + c**2
    h = math.sqrt(length)
    return h

triangle(3, 4)

"""
Optimal code:
    - merge the length and the hypethenuse declaration

"""
def triangle(b, c):
    h = math.sqrt(b**2 + c**2)
    return h

triangle(3, 4) # Output: 5
triangle(6, 8) # Output: 10
triangle(12, 16) # Output: 20
