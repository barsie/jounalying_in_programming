package Lessons.StaticMethodsVariables;

import java.util.Scanner;

public class MethodsParameters {

    /**
     * WORKING WITH A PARAMETER OF TYPE INT
     * Print all divisors of N
     * Assuming N is a positive number.
     */
    static void pringDivisors(int number){
        int i;
        System.out.println("The divisors of: " + number + " are: ");
        for (i = 1; i <= number; i++) {
            if (number % i == 0) { //Does the provided number divide evenly the variable
                System.out.println(i);
                // System.out.println("The number has: ");
            } 

            // TO DO
            //  ... compute how much times did the provide number got divided evenly by the variable
            //  ... convert the method to a prime number verification
        }
    }

    /*
        WORKING WITH TWO PARAMETERS AND PRIVATE METHODS

        Write a private subroutine named printRow. 
        It should have a parameter ch of type char and a parameter N of type int. 
        Thesubroutine should print out a line of text containing N copies of the character ch.
    */ 
    private static void printRow( char character, int number){
        int i; // Loop-control variable for counting up the copies

        for(i = 1; i <= number; i++){ //the counter start at one because char type count from 1.
            System.out.println(character);
        }
    }

    /**
     * Finally, let’s do an example that shows how one subroutine can build on another. 
     * Let’s write a subroutine that takes a String as a parameter.
     * For each character in the string, it should print a line of output containing 3 copies of that character. 
     * It should use the printRow() subroutine defined above to produce the output.
     */

    private static void printRowString(String string){
        int i; // Loop-control variable for counting up the characters in the string provided

        for(i = 0; i < string.length(); i++){
            // charAt() return a character at a specified index in a string
            printRow(string.charAt(i), 3); //printRow method is called into another method
        }

       
    } 

    /**
     * The entire values of an array can be passed to a subroutine/method as a single parameter.
     * For example, we might want a subroutine to print all the values in an integer array in a neat format, separated by commas
     * and enclosed in a pair of square brackets.
     * 
     * Printing a list of numbers
     */

    static void printValuesList(int[] list){

        System.out.print("[");
        int i; // Loop-control variable for counting up the number of items in the array list provided

        for(i = 0; i < list.length; i++){
            if (i > 0) 
                System.out.print(","); // Do not print comma in front of index 0

            System.out.print(list[i]); // Read the list array elements
        }

        System.out.print("]");
    }


    public static void main(String[] args) {

            pringDivisors(15);

            
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.print("Add your text input here: ");
            input = scanner.nextLine();
            printRowString(input); //Calling a private method with two paramenter
            
            int[] listNumbers = {1, 3, 4};
            printValuesList(listNumbers);
    }
}
