package Assignments.GMS;

import java.util.Scanner;

public class Admin {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- UOPEOPLE COURSE MANAGEMENT SYSTEM ---\n");
            System.out.println("1. Add New Course");
            System.out.println("2. Register a New Student");
            System.out.println("3. Enroll a Student in Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Student's Overall Grade");
            System.out.println("6. View Total Enrolled Students");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    registerStudent();
                    break;
                case "3":
                    enrollStudent();
                    break;
                case "4":
                    assignGrade();
                    break;
                case "5":
                    calculateGrade();
                    break;
                case "6":
                    System.out.println("Total Enrolled Students: " + Course.getTotalEnrolledStudents());
                    break;
                case "7":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addCourse() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Max Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        CourseManagement.addCourse(code, name, capacity);
        System.out.println("Course added.");
        System.out.println("The new course added is " + name + " with a capacity of " + capacity + " students");
    }

    private static void registerStudent() {
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        CourseManagement.addStudent(name, id);
        System.out.println("A Student with the " + name + " and ID" + id + "registered.");

    }

    private static void enrollStudent() {
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        boolean isSuccesful = CourseManagement.enrollStudent(id, code); 
        if (isSuccesful == true) { //enroll only if the course already exist in the system
            System.out.println("Enrolment successful.");
        }else {System.out.println("Something it's wrong with the enfrollment, please try again");}
        // System.out.println(isSuccesful ? "Enrollment successful." : "Enrollment failed (may be full or invalid).");
    }

    private static void assignGrade() {
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());
        CourseManagement.assignGrade(id, code, grade);
        System.out.println("This grade" + grade + " is assigned to the studet " + id + ".");
    }

    private static void calculateGrade() {
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        double avg = CourseManagement.getOverallGrade(id);
        System.out.println("Overall Grade: " + avg);
        System.out.println("The studen might not be in the system");
    }
}

