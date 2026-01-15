package Lessons.PolymophysmInheritance;

class Fruit {
    public void foodShape(){
        System.out.println("This is a generic fruit shape");
    }
    public void foodColor( String color){
        System.out.println("This is a generic fruit color modified by color");
    }

    public void foodColor(){
        System.out.println("This is a generic fruit color");
    }
}
class Pineaple extends Fruit{ 
    @Override
    public void foodShape(){
        System.out.println("Pineapple is a fruit with a unique shape");
    }
    @Override
    public void foodColor(){
        System.out.println("Pineapple is a yellow fruit color");
    }
}

public class Overriding {
    public static void main(String[] args) {
       //Fruit Coconaut = new Fruit();
       Fruit Dos = new Pineaple();
       Dos.foodShape();
       Dos.foodColor();
       Dos.foodColor("green");
       //Coconaut.foodShape();
       //Coconaut.foodColor();
    }
}
