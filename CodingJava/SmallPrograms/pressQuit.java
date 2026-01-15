package SmallPrograms;

import java.util.Scanner;

public class pressQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) { //true = !input.equals("quit")
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass")) {
                continue;
            }
            if(input.equals("quit"))
                break;
            System.out.println(input); //echoed back whatever the user enters.
        }

        // do{

        //     System.out.println("Input: ");
        //     input = scanner.next().toLowerCase();
        //     System.out.println(input); //echoed back whatever the user enters.

        // } while(!input.equals("quit"));

    }
}
