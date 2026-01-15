package Assignments;

import java.util.Scanner;

public class StudentManagementSystem {

    // Specify a Number of possible administions
    static int MAX_ADMISSION = 10; // Fixed limitation, future uptades should start here.

    // Define Arrays that will contain the studen information
    static String[] studentName = new String[MAX_ADMISSION];
    static String[] studentID = new String[MAX_ADMISSION];
    static byte[] studentAge = new byte[MAX_ADMISSION];
    static String[] studentGrade = new String[MAX_ADMISSION];

    // Student Registration Count
    static int registrationCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean exit = false; // initialize a boolean
        
        while (!exit) {
            
            adminMenu(); //prompt admin menu
            int option = getByteInput(scanner, "Select An Option: ");

            switch (option) {
                case 1:
                    AddStudent(scanner);
                    break;
                case 2:
                    UpdateStudent(scanner);
                    break;
                case 3: 
                    totalRecord(scanner);
                    break;
                case 4:
                    System.out.println("Quiting the system, Thank for using it");
                    exit = true;
                default:
                    System.out.println("You selected an invalid option. Please try again");;
            }

        }

    }

    // Administration Intarface: 
    static void adminMenu() {
        System.out.println("\n------- Student Management Admin Menu ------");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student Record");
        System.out.println("3. All available students");
        System.out.println("4. Exit");
    }

    // Get and handdle user inputs 
    static byte getByteInput(Scanner scanner, String prompt){ //scanner method it's being instanciated as parameter
        while (true) {
            System.out.print(prompt);
            try {
                byte input = Byte.parseByte(scanner.nextLine().trim()); // trim() remove white spaces
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Try an option number between 1 and 4.");
                System.out.println("If your error persists, Please contact the Admin.");
            }
        }
    }
    //  Adding Student logic
    static void AddStudent(Scanner scanner){
        // Use and if statement to check admission availabiliy
        if (registrationCount >= MAX_ADMISSION) {
            throw new IllegalArgumentException("Total admission exceeded, wait for next term PLEASE.");
        }
        // Elaborating input structure
        System.out.print("Enter student full name (example: John Doe Lorem): "); 
        String name = scanner.nextLine().trim();

        // prompt user to input the age
        byte age = getByteInput(scanner, "Enter student age: ");

        // prompt user to input student id
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();

        // Check if the student id exists 
        if(findStudentIndexId(id) != -1){
            System.out.println("Student ID already exist in our database. Please/request a new ID.");
            return;
        }
        // prompt user to input student grades
        System.out.print("Enter student American standard grade (A, -B, C, +A): ");
        String grade = scanner.nextLine().trim().toUpperCase();

        studentName[registrationCount] = name;
        studentAge[registrationCount] = age;
        studentID[registrationCount] = id;
        studentGrade[registrationCount] = grade;

        // increment registration after inserting the required data
        registrationCount++;
        
        System.out.println("Congratulations!! Student Added successfully!");
    }

    static void UpdateStudent(Scanner scanner){

        // User input
        System.out.print("Enter Student index to update: ");

        String id = scanner.nextLine();
        int index = findStudentIndexId(id);

        // Find student assigned ID
        if(index != -1){
            System.out.println("Student ID not in database");
        }

        System.out.print("Enter new student name: ");
        studentName[index] = scanner.nextLine().trim();

        studentAge[index] = getByteInput(scanner, "Enter new student Age: ");
        // while (!scanner.hasNextByte()) {
        //     throw new IllegalArgumentException("Invalid input. Please try a inserting the age in number");
        // }

        System.out.print("Enter new student grade: ");
        studentGrade[index] = scanner.nextLine().trim().toUpperCase();

        System.out.println("\n Student information updated successfully \n");

    }

    static void totalRecord(Scanner scanner){

        // Checking registration status
        if (registrationCount == 0) {
            System.out.println("There are not students in the database yet");
        }

        System.out.println("\n -------- All registered students -------------\n");
        int i; //loop variable
        for(i = 0; i < registrationCount; i++){
            System.out.printf("Student %d\n", 1 + i); //printf: enables the introduction of new embedded expressions
            System.out.println("Name: " + studentName[i]);
            System.out.println("Age: " + studentAge[i]);
            System.out.println("Grade: " + studentGrade[i]);
        }

    }

    static int findStudentIndexId(String id){
        int i; //loop variable
        for(i = 0; i < registrationCount; i++){
            if (studentID[i].equalsIgnoreCase(id)) {
                return i; //return student id if it matches
            }
        }
        return -1; // return error of array out of size.
    }

}


 /*
     In the last assignment we specified an array with 3 items from which we started computing
     additionals, upting existing, borrowing and returning. Here in this assignment is crucial
     we are specifying a limit of pseudo possible adminission in a year for example.
    */ 


    
    /*
    We use arrays instead of variables here beacuase we what to be able to host group of data atributes
    example: studentNames.
    */ 