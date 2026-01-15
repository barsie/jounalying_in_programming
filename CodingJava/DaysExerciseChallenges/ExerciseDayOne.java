package DaysExerciseChallenges;

import java.awt.*;
import java.util.Scanner;


public class ExerciseDayOne {
    public static void main(String[] args) {

        // Define user input
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        // calculate the distance between two points
        Point pointOne = new Point(x, y);
        Point pointTwo = new Point(x, y);
        
        pointOne.x = scanner.nextInt();
        System.out.print("Add your point x1 index: ");
        pointOne.y = scanner.nextInt();
        System.out.print("Add your point y1 index: ");
        pointTwo.x = scanner.nextInt();
        System.out.print("Add your point x2 index: ");
        pointTwo.y = scanner.nextInt();
        System.out.print("Add your point y2 index: ");

        // Apply distance formula
        float distance = (float) Math.sqrt((pointTwo.x - pointOne.x) + (pointTwo.y - pointOne.y));

        // double result = pointTwo - pointOne;
        System.out.println(distance);

        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

