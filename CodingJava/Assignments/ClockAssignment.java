package Assignments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockAssignment {

    // Formatter to display date and time
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    // Shared time object
    private static volatile String currentTime = "";

    // Thread to update the time in the background
    static class TimeUpdater extends Thread {
        @Override
        public void run() {
            while (true) {
                currentTime = formatter.format(new Date());
                try {
                    Thread.sleep(500); // Update every 0.5 second
                } catch (InterruptedException e) {
                    System.out.println("Updater interrupted");
                }
            }
        }
    }

    // Thread to display the time on the console
    static class TimeDisplay extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Current Time: " + currentTime);
                try {
                    Thread.sleep(1000); // Print every 1 second
                } catch (InterruptedException e) {
                    System.out.println("Display interrupted");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create multiple threads as for the above classes
        Thread updater = new TimeUpdater();
        Thread display = new TimeDisplay();

        // Set priorities
        updater.setPriority(Thread.MIN_PRIORITY);  // Lower priority
        display.setPriority(Thread.MAX_PRIORITY);  // Higher priority

        // Start threads
        updater.start();
        System.out.println("The time have been updated");
        display.start();
    }
}

