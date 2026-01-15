package Lessons.ObjectOrientedProg;

public class Professors extends Person {
    @Override
    public String setPassportID(String personName) {
        // TODO Auto-generated method stub
        return super.setPassportID(personName);
    }


    public static void main(String[] args) {
        Person MathProfessor = new Professors();
        MathProfessor.setPassportID("Ant Man");

        System.out.println(MathProfessor.getPassportID());
    }
}
