package Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {

    // Global static variable declaration
    static String[] BookTitles = {"Love Now", "Big Inputs", "Programming Girls"};
    static String[] BookAuthors = {"Tai Pei", "Marcos Van", "Lime Stephan"};
    static int[] BookQuantity = new int[3];

    // Initialize book counter
    static int bookCount = 3; // Initial count based on predefined books

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop to select options
        boolean exit = false;

        while (!exit) {
            
            printMenu(); // All option to select

            int option = getIntInput("Select an option: ");

            switch (option) {
                case 1:
                    AddBook(scanner);
                    break;
                case 2:
                    BorrowBook(scanner);
                    break;
                case 3:
                    ReturnBook(scanner);
                    break;
                case 4:
                    System.out.println("List of books: " + Arrays.deepToString( BookTitles));
                    System.out.println("List of authors: " + Arrays.deepToString(BookAuthors));
                    System.out.println("There are books in total: " + Arrays.toString(BookQuantity));
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;

                default:
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n------- Library Menu ------");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. All the Books");
        System.out.println("5. Exit");
    }

    static int getIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            try { // validating input and capturing error 
                return Integer.parseInt(scanner.nextLine().trim()); //remove white spaces on input
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    // checking if book exist in the library
    static int findBookIndex(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (BookTitles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1; // Book not found
    }

    // Build method that updates global arrays

    // Adding books methods
    static void AddBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim().toUpperCase();

        int qty = getIntInput("Enter quantity to add: ");

        int index = findBookIndex(title);
        if (index != -1) {
            BookQuantity[index] += qty; // Update quantity of existing book
            System.out.println("Updated quantity of existing book.");
        } 
        else {
            
            if (bookCount == BookTitles.length) {
                resizeArrays();  // Resize arrays when they are full
            }
            BookTitles[bookCount] = title;
            BookAuthors[bookCount] = author;
            BookQuantity[bookCount] = qty;
            bookCount++;
            System.out.println("Added new book to the library.");
            System.out.println("The add book is: " + title);
            System.out.println("The library has: " + BookTitles.length + "'s now");
            System.out.println("The last book adde is: " + (BookTitles.length - 1));
            System.out.println("This are the total current books: " + Arrays.deepToString(BookTitles));
        }
    }

    // BorrowBooks Method
    static void BorrowBook(Scanner scanner) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().trim().toLowerCase();

        int qty = getIntInput("Enter quantity to borrow: ");

        int index = findBookIndex(title);
        if (index == -1) {
            System.out.println("Error: Book not found.");
        } else if (BookQuantity[index] >= qty) {
            BookQuantity[index] -= qty; // Decrease quantity
            System.out.println("Successfully borrowed " + qty + " copy(ies) of \"" + title + "\".");
            System.out.println("The library has remaining: " + BookQuantity.length);
        } else {
            System.out.println("Error: Not enough copies available.");
        }
    }

    // ReturnBook method 
    static void ReturnBook(Scanner scanner) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().trim().toLowerCase();

        int qty = getIntInput("Enter quantity to return: ");

        int index = findBookIndex(title);
        if (index == -1) {
            System.out.println("Error: Book not found in the system.");
        } else {
            BookQuantity[index] += qty; // Increase quantity
            System.out.println("Successfully returned " + qty + " copy(ies) of \"" + title + "\".");
            System.out.println("The library has increased the books to: " + BookQuantity.length);
            System.out.println("--------- Here are the total book: ---------");
            System.out.println(Arrays.deepToString(BookTitles));
        }
    }

    // Handle array sizes
    static void resizeArrays() {
        int newSize = BookTitles.length * 2; // Double the size of the arrays
        BookTitles = resizeArray(BookTitles, newSize);
        BookAuthors = resizeArray(BookAuthors, newSize);
        BookQuantity = resizeArray(BookQuantity, newSize);
    }

    // Helper method to resize an array of type String
    static String[] resizeArray(String[] oldArray, int newSize) {
        String[] newArray = new String[newSize]; // copying array to a new variable
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    // Helper method to resize an array of type Int
    static int[] resizeArray(int[] oldArray, int newSize) {
        int[] newArray = new int[newSize];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }
}
