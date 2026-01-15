package Lessons.StaticMethodsVariables;

import java.awt.*;

public class StaticMethodsVariables {
    Point center;

    double radius;

    static int numberOfCircles;

    StaticMethodsVariables () {
        numberOfCircles ++;
    }

    StaticMethodsVariables (Point center, double radius){
        numberOfCircles++;
        this.center = center;
        this.radius  = radius;
    }

    double getPerimeter(){return 2 * Math.PI * this.radius;}

    double getArea(){return Math.PI * this.radius * this.radius;}

    void setCenter(Point center){this.center = center;}

    void setRadius(double radius){this.radius = radius;}

    static int getNumberOfCircles(){return numberOfCircles;}

    public static void main(String[] args) {
        System.out.println(StaticMethodsVariables.numberOfCircles);
        
        StaticMethodsVariables c1 = new StaticMethodsVariables(new Point(1,2), 3);
        // c1.numberOfCircles = 10;
        System.out.println(StaticMethodsVariables.getNumberOfCircles());
        
        StaticMethodsVariables c2 = new StaticMethodsVariables(new Point(2,4), 6);
        System.out.println(StaticMethodsVariables.numberOfCircles = 10);
    }

}
