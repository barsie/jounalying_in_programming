package Lessons;

import java.text.NumberFormat;

public class FormatingNumbers {
    public static void main(String[] args) {
        // Format numbers in java
        // We cannot create an instance of NumberFormat because is abstract
        // NumberFormat called with a dot method is a factory method because it creates numerous methods.

        NumberFormat currency  = NumberFormat.getCurrencyInstance();
        String result = currency.format(1283456.897);
        System.out.println(result);

        // method chaining
        
        String result1 = NumberFormat.getPercentInstance().format(0.12);
        System.out.println(result1);
    }
}
