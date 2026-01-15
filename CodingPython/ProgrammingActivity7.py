def invert_program():
    
    # Initialize a class program
    program = {
        "stud1": ['CS1101', 'CS2402', 'CS2001'], 
        "stud2": ['CS2402', 'CS2001', 'CS1102'],
    }
    
    inverted = {}

    # Iterate through each student and their courses
    for student, courses in program.items():
        for course in courses:
            if course not in inverted:
                inverted[course] = [student]  # Initialize with the current student
            else:
                inverted[course].append(student)  # Add the student to the course list
    
    # Make sure every course has exactly two students enrolled
    # Remove courses with less than 3 students
    inverted = {course: students for course, students in inverted.items() if len(students) >= 1}
    
    return inverted

# Test the function
inverted_program = invert_program()
print(inverted_program)
type(inverted_program)

#print(invert_program())