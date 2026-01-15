package Assignments.GMS;

import java.util.ArrayList;

public class CourseManagement {
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();

    // Add a new course
    public static void addCourse(String code, String name, int capacity) {
        courses.add(new Course(code, name, capacity));
    }

    // Register a new student
    public static void addStudent(String name, String id) {
        students.add(new Student(name, id));
    }

    // Find student by ID
    public static Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getID().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    // Find course by code
    public static Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    // Enroll student
    public static boolean enrollStudent(String studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        if (student != null && course != null) {
            return student.enrollInCourse(course);
        }
        return false;
    }

    // Assign grade
    public static void assignGrade(String studentId, String courseCode, double grade) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.assignGrade(courseCode, grade);
        }
    }

    // Get average grade
    public static double getOverallGrade(String studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            return student.calculateOverallGrade();
        }
        return 0.0;
    }
}

