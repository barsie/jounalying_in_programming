package Lessons.StaticMethodsVariables;

public class ExampleStatics {
    static byte numberStaticVariable = 90; //static variable declaration
    byte numberNonStaticVariable = 45; // non-static variable declaration

    static void staticMethod(){
        System.out.println("The static variable value is: " + numberStaticVariable);
    }

    void NonStaticMethod(){
        int [] list = {1, 2, 5, 60};
        int i;
        for(i = 0; i < list.length; i++){
            System.out.print(list[i]);
        }
        System.out.println("The non-static varible values is: " + numberNonStaticVariable);
    }

    public static void main(String[] args) {

        ExampleStatics.staticMethod();
        ExampleStatics Access = new ExampleStatics();
        Access.numberNonStaticVariable = -34;
        Access.NonStaticMethod();
    }
}
