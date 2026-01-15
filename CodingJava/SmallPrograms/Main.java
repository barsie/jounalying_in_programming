package SmallPrograms;

import java.util.Date;

public class Main {
    public static void main(String[] args){

        // PRIMITIVE TYPES: 8 including short 
        byte age = 30;
        int viewsCount = 123_456_789; // the _ is similar to the decimal ,
        long likesCount = 41_236_549_780L; // specify L with large numbers else we are prone to errors
        float price = 10.99F; // specify F with float else the type it's interpreted as double
        char letter = 'A'; //surround single character with single quotes and multiple characters with double quotes
        boolean isRaining = false;

        // REFERENCE TYPES: they allocate memory and allow instances of objects
        Date now = new Date(); // now it's an instance of the object data it will - 
        now.getTime();
        System.out.println(now);
        System.out.println("Maria Jose " + age);
        System.out.println(viewsCount);
        System.out.println(likesCount);
        System.out.println(price);
        System.out.println(letter);
        System.out.println(isRaining);
    }
}

// public is a access modifier
//  class are name in pascal example: MyFunction
//  methods are named in camel case, example: myMethod

