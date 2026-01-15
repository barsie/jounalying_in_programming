package Lessons;


public class MathMethod {
    public static void main(String[] args) {
        // working with the Math method
        // int result = Math.round(1.4f);
        // int result1 = (int)Math.ceil(1.5f);
        // int result2 = (int)Math.sqrt(256);
        // int result3 = Math.min(result1, result2);

        // random numbers
        // double number = Math.round(Math.random()*100);
        int number = (int)(Math.random() * 100);
        System.out.println("The produced random number is: " + number);

        // System.out.println("The max result is: "+ result3);
        // System.out.println("The round result is: "+ result);
        // System.out.println("The ceil result is: "+ result1);
        // System.out.println("The squared result is: "+ result2);
    }
}
