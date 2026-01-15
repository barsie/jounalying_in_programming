package Lessons;

public class TypeCasting {
    public static void main(String[] args) {
        /*Implicit casting, when one of the two values are authomatically casted
        byte are implicitly casted as short, short as int and int as long
        Implicit casting happen whenever we are not going to lose data
        
        */ 
        short x = 1;
        int y = x + 2;
        System.out.println(y);

        /* Explicit casting, requires to especify the casting datatype
        The explicit casting can only happen between compatibles types
        */ 
        double number = 1.1;
        int ynumber = (int)number + 2;
        System.out.println(ynumber);

        /*To deal with incompatible datatypes when casting ww use class wrappers*/
        
        String numberName = "123";
        int ynumberName = Integer.parseInt(numberName) + 2;
        System.out.println(ynumberName);
    }
}
