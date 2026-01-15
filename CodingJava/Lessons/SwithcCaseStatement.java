package Lessons;

public class SwithcCaseStatement {
    public static void main(String[] args) {
        String role = "Admin";

        switch (role) {
            case "Admin":
                System.out.println("You're an Admin");
                break;
            case "Moderator":
                System.out.println("You're a moderator");
                break;
            default:
                break;
        }
    }
}
