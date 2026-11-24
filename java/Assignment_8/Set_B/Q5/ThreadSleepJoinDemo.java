/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 5:
 * Write a Java program where:
 * a) Thread T1 prints numbers from 1 to 5 with a delay of 500ms using sleep().
 * b) Thread T2 should start only after T1 completes, using join().
 * Print appropriate messages to show execution order.
 */

class T1Worker extends Thread {
    @Override
    public void run() {
        System.out.println("[T1 Started]: Printing numbers 1 to 5 with 500ms delay...");
        for (int i = 1; i <= 5; i++) {
            System.out.println("  [T1] Number: " + i);
            try {
                Thread.sleep(500); // 500ms delay
            } catch (InterruptedException e) {
                System.out.println("T1 interrupted: " + e.getMessage());
            }
        }
        System.out.println("[T1 Finished execution.]");
    }
}

class T2Worker extends Thread {
    @Override
    public void run() {
        System.out.println("[T2 Started]: T1 has completed, so T2 is now running!");
        for (int i = 10; i <= 15; i++) {
            System.out.println("  [T2] Processing step: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("T2 interrupted: " + e.getMessage());
            }
        }
        System.out.println("[T2 Finished execution.]");
    }
}

public class ThreadSleepJoinDemo {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Thread sleep() and join() ===");

        T1Worker t1 = new T1Worker();
        T2Worker t2 = new T2Worker();

        // Start T1
        t1.start();

        try {
            System.out.println("Main Thread: Waiting for T1 to finish using t1.join()...");
            t1.join(); // Main thread blocks until T1 finishes
            System.out.println("Main Thread: T1 has successfully finished. Now starting T2.");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        // Start T2 only after T1 has completed
        t2.start();

        try {
            t2.join(); // Wait for T2 before finishing main
        } catch (InterruptedException ignored) {}

        System.out.println("Main Thread: All threads have completed execution.");
    }
}

