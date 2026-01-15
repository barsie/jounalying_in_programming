package Assignments.GMS;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String ID;
    private ArrayList<Course> coursesEnrolledIn; // Refer to the data from course object
    private HashMap<String, Double> grades; // Map Key-value grades with Key: Course Code, Value: Grade

    public Student(String name, String studentId) {
        this.name = name;
        this.ID = studentId;
        this.coursesEnrolledIn = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Course> getCoursesEnrolledIn() {
        return coursesEnrolledIn;
    }

    // Method to Enroll in a course
    public boolean enrollInCourse(Course course) {
        if (course.getCurrentEnrollment() < course.getMaxCapacity()) {
            coursesEnrolledIn.add(course);
            course.increaseEnrollment(); // Track enrollment in Course
            return true;
        }
        return false;
    }

    // Assign grade for a course
    public void assignGrade(String courseCode, double grade) {
        grades.put(courseCode, grade);
    }

    // Calculate overall grade
    public double calculateOverallGrade() {
        double total = 0.0;
        int count = 0;
        for (String courseCode : grades.keySet()) {
            total += grades.get(courseCode);
            count++;
        }
        return (count > 0) ? (total / count) : 0.0;
    }
}

