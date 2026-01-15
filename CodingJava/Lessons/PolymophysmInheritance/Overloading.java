package Lessons.PolymophysmInheritance;

public class Overloading {

    public int reduction( int a, int b ){
        return a - b;
    }

    public int reduction(double a, double b){
        return (int) (a - b);
    }

    public static void main(String[] args) {
        Overloading Reduction = new Overloading();
        System.out.println("Addition of Ingeger numbers: " + Reduction.reduction(60, 56));
        System.out.println("Adddition of Double numbers: " + Reduction.reduction(90.5, 568.90));
    }
}
