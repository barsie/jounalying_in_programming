package SmallPrograms;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MorgageCalculator {
    public static void main(String[] args) {
        
        // Declare Month in a year and percentage as constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float monthtlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Add your Principal (1K - 1M): ");
            principal = scanner.nextInt();
            
            if (principal >= 1_000 && principal <= 1_000_000)                
                break;
            System.out.println("Add a valid number between 1k and 1M: ");
    
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30){  
                monthtlyInterest = annualInterest / PERCENTAGE / MONTHS_IN_YEAR;
                break; 
            }   
            System.out.println("Enter a valid monthly interes between 1 and 30"); 
        }

        while (true) {
            System.out.print("Periods (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break; 
            }
            System.out.println("Enter a valid year between 1 and 30.");  
        }

        double morgage = principal * (monthtlyInterest * Math.pow(1 + monthtlyInterest, numberOfPayments) 
        / (Math.pow(1 + monthtlyInterest, numberOfPayments) - 1)) ;

        String morgageFormated = NumberFormat.getCurrencyInstance(Locale.US).format(morgage);
        System.out.println("Morgage: "+ morgageFormated);

    }
}
