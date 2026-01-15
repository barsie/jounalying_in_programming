package Assignments.GMS;

public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;

    // Static variable to track total enrollments
    public static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    // Increase enrolled count
    public void increaseEnrollment() {
        this.currentEnrollment++;
        totalEnrolledStudents++;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}


