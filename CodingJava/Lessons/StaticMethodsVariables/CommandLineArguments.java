package Lessons.StaticMethodsVariables;

public class CommandLineArguments {
    public static void main(String[] args) {
        System.out.println("You entered: " + args.length + " command-lines arguments");

        String name = "Mr. Barila";


        if (args.length > 0) {
            System.out.println("The were: ");

            int i; //Loop counter

            for(i = 0; i < args.length; i++){
                System.out.println(" " + args[i]);
            }
        }
    }
}
