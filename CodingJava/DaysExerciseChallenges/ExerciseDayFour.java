package DaysExerciseChallenges;

import java.util.Scanner;

public class ExerciseDayFour {

    /*
        Create a program that compute a 3N+1 sequence according to the rule, "if N is odd, 
        multiply it by 3 and add 1; if N is even, divide it by 2; continue until N is equal to 1
    */ 

    static void sequencePrint(){
        System.out.println("This message will print an 3N+1 sequence\n for the starting value that you specified.");
        Scanner scanner = new Scanner(System.in);
        int K = 0;
        do{
            if (K < 0) {
                System.out.println("Enter a starting value: ");
                System.out.println("To end the program enter zero: ");
                K = scanner.nextInt();
                print3Nsequence(K);
            }
        }while (K > 0);
    }

    static void print3Nsequence(int startingValue){
        int number = startingValue;
        int count = 0;

        while (number > 1) {
            if (number % 2 == 1) {
                number = 3 * number + 1;
            } 
            else 
            number = number / 2;
            
            count ++;
            System.out.println("The result of " + number + " its even");
        }
    }

    public static void main(String[] args) {
        sequencePrint();
        print3Nsequence(5);
    }
}
