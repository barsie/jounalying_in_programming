package SmallPrograms;

import java.util.Scanner;

public class TemperatureEvaluation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your desire temperature: ");
        int temperature = scanner.nextInt();
        // int temperature = 30;
        if (temperature > 30) {
           System.out.println("It's a hot day"); 
        }
        else if (temperature > 20 && temperature < 30)
            System.out.println("It's a nice day");
        else
            System.out.println("It's cold!");
    
    }
}
