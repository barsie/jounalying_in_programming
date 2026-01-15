package TestFeatures;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // String input = JOptionPane.showInputDialog("Please add your number: ".length());
        // System.out.println("Your string lengh is: " + input);
        
        ArrayList <String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("blue");
        colors.remove("green"); // this is not counted is not added to the array
        System.out.println("arraylist size is: " + colors.size());
        int y;
        int x = 0;
        if(x < 0){
            y = 1;
        } else{
            y = 2;
        }


        int a = 10;

a *= 2 + 3;

System.out.println(a);

int i = 0;

while (i < 5) {

    if (i == 3)

        break;

    System.out.print(i + " ");

    i++;

}

int f = 8;

int g = 4;

System.out.println(f & g);



int j = 5;

while (j > 0) {

 System.out.println(j + " ");

 j--;

 }



 int num = 7;

switch (num) {

    case 1:

        System.out.println("One");

        break;

    case 2:

        System.out.println("Two");

        break;

    default:

        System.out.println("Other");

}

    }
}
