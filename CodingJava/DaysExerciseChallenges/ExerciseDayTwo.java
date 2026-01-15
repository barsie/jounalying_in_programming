// The 3N + 1 Problem
package DaysExerciseChallenges;

import java.util.Scanner;

public class ExerciseDayTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your starting counter: ");
        int number = scanner.nextInt();
        // System.out.println(number);

        while (number <= 0) {
            System.out.println("Starting counter must be zero: ");
        }
        int counter = 0;
        while (number != 1) {

            if (number % 2 == 0){
                number = number / 2;
                System.out.println(number + " It's Even");
            }
            else{
                number = number * 3 + 1;
                System.out.println(number + " It's ods");
            }
            // System.out.println(number);
            counter = counter + 1;
        }

        System.out.println();
        System.out.println("There were: " + counter + " ternm in the secuence");

    }
}
