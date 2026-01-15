package Lessons;

public class Constants {
    public static void main(String[] args) {
        // Declaring constant only requires to add the reserved word file befor the data type

        // Calculate de area of a cyrcle

        final float PI = 3.141516F;
        float radio = 34f;
        float area = (float) (PI*Math.pow(radio, 2));
        System.out.println(area);
    }
}
