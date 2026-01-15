package SmallPrograms;

public class FruitsIteration {
    public static void main(String[] args) {
        
        String fruitList [] = {"Mangoes", "Apples", "Avocatos", "Pineaples"};

        // Read it with a For each loop
        for (String string : fruitList) {
            System.out.println(string);
        }
        System.out.println("================================");

        //  read it with a for loop
        for(int i = 0; i < fruitList.length; i++)
            System.out.println(fruitList[i]);
        
        System.out.println("================================");
    }
}
