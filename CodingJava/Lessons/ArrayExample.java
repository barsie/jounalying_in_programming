package Lessons;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        String[] roleList = new String[3];
        roleList[0] = "User";
        roleList[1] = "Admin";
        roleList[2] = "Super Admin";

        ArrayList<String> roleList2 = new ArrayList<>(Arrays.asList("User", "Admin", "Super Admin")); 

        // Getting element at index 1
        System.out.println(roleList[1]); //Array
        System.out.println(roleList2.get(1)); //ArrayList by calling a method.
        System.out.println(roleList.length); // Array with a field
        System.err.println(roleList2.size()); // ArrayList by caling a method.

        // Adding element to Array is impossible

        // Adding elements to ArrayList
        roleList2.add("Content Manager");

        // getting all user roles

        // printing user roles with Arrays
        System.out.println(roleList); // this print the memory location.
        System.out.println(Arrays.deepToString(roleList));

        System.out.println("System roles:"); // this prints all the element of a list
        for (int i = 0; i < roleList.length; i++) {
            System.out.println(roleList[i]);
        }

        // printing user roles with ArrayList
        System.out.println(roleList2);
        //System.out.println(ArrayList.deepToString(roleList2)); // method does not exist in array.
    }
}
