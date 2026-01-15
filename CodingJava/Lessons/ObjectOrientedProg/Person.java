package Lessons.ObjectOrientedProg;

public class Person {

    /*
        encapsulation: happens when we keep sensitive data hidden from the user and only make it accessible
        by building a public getter or setter method that makes the data available for outside the initial defined object. 
    */
    // define to private a sensible data 
    String name;
    String nationality;
    int age;
    private String passportID;

    // building a public getter
    public String getPassportID(){
        return (passportID);
    }

    // building a public sette
    public String setPassportID(String ID){
       return this.passportID = ID;
    }

    public static void main(String[] args) {
        
        // Building diferent personas

        Person Student = new Person();
        // Student.name = "Albert Einstein"; // this will generate an error, the variable name is declared as private
        Student.setPassportID("P10098ED4567"); // use setter to set the value

        Person Profesor = new Person();
        Profesor.setPassportID("P10097ED4507");

        System.out.println(Student.getPassportID()); // use getter to output the value
        System.out.println(Profesor.getPassportID());

    }
}
