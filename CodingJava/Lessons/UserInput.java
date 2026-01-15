package Lessons;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the scanner method work with datatypes and have to be specified
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        
        // System.out.print("name: ");
        /*this next method only count one token: that is a character or series of characters*/
        System.out.print("Full Name: ");
        String fullname = scanner.next();

        System.out.println("You are: " + age + " years old");
        System.out.println("Your name is: " + fullname);
        
    }
}
