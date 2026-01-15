package Lessons.Multithreading;

public class UserVerification extends Thread {

    private int verificationValue = 0;

    @Override
    public void run(){

        for (int i = 0; i <= 5; i++) {
            System.out.println("User Verification in progress..." + i);

            try {
                if (verificationValue == 0)
                    System.out.println("Verifying...");
                Thread.sleep(1500); // Simulating a delay for user verification
            } catch (InterruptedException e) {
                System.out.println("User Verification completed successfully!");
            }
        }


    }
}

