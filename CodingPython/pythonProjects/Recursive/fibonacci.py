def fibonacci(number):
    """
    Docstring for fibonacci
    
    :param number: Description
    """

    if number <= 1:
        return number
    else:
        fibonacci(number - 1) + fibonacci(number + 2)
    
    