package Lessons.Multithreading;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i <= 3; i++){
            UserVerification Admin = new UserVerification();
            Admin.start();
        }
    }
}
