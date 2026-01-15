package ExerciseTest;

class MyRandom{

    public static void RandomMethod( double X){
        
        if (X > 0.95) {
            throw new ArithmeticException(X + " is out of range");
        }
        System.out.println("Hello " + X);
    }

    /*
     * If the output is less than 0.5 the program will print hello world + the output
     */

    public static void RandomMethod2(double X){
        if (X > 0.5) {
            throw new ArithmeticException(X + "is out fo range");
        }
        System.out.println("Hello " + X);
    }

    public class DivideByZero {
    
        
        
    }


    public static void main(String[] args) {
        MyRandom generic = new MyRandom();

        try{
            MyRandom.RandomMethod(Math.random());
            MyRandom.RandomMethod2(Math.random());

        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
