package Lessons;
import java.util.Arrays;

public class Lesson_Arrays {
    public static void main(String[] args) {
        
        /*Arrays in java are fixed in length to add elements to an array the use of collection
         * classes its needed.
         * Arrays are not sorted by default, but can be sorted usin array methods
         * An overloaded method is a method that its implemented with different parameter types base o the datatype.
         */

         int[] numbers = {10, 7, 1, 2, 3, 4};
         Arrays.sort(numbers);
         System.out.println(numbers.length);
 
         System.out.println(Arrays.toString(numbers));
        
        /* MULTIDIMENSIONAL ARRAYS
        First [] indicate the number of arrays
        * Second [] indicates the nombre of elements in each array
        */
   
       // int[][][] numbers = new int[2][3][5];
       // numbers[0][0][0] = 1;
       // System.out.println(Arrays.deepToString(numbers));
   
       int[][] number = {{555, 0, 90}, {26, 03, 2027}};
       System.out.println(Arrays.deepToString(number));
    }
}
