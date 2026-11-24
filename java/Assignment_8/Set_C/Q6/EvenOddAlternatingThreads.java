/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 6:
 * Write a Java program to create two threads:
 * a) EvenThread → prints even numbers 2 to 20
 * b) OddThread → prints odd numbers 1 to 19
 * Use inter-thread communication to ensure even and odd numbers print alternately.
 */

class NumberCoordinator {
    private int currentNumber = 1;
    private final int MAX = 20;

    public synchronized void printOdd() {
        while (currentNumber <= MAX) {
            // If current number is even, wait for EvenThread
            while (currentNumber % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (currentNumber <= MAX) {
                System.out.println("[OddThread]  : " + currentNumber);
                currentNumber++;
                notify(); // Notify EvenThread
            }
        }
    }

    public synchronized void printEven() {
        while (currentNumber <= MAX) {
            // If current number is odd, wait for OddThread
            while (currentNumber % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (currentNumber <= MAX) {
                System.out.println("[EvenThread] : " + currentNumber);
                currentNumber++;
                notify(); // Notify OddThread
            }
        }
    }
}

class OddThread extends Thread {
    private NumberCoordinator coordinator;

    public OddThread(NumberCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public void run() {
        coordinator.printOdd();
    }
}

class EvenThread extends Thread {
    private NumberCoordinator coordinator;

    public EvenThread(NumberCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public void run() {
        coordinator.printEven();
    }
}

public class EvenOddAlternatingThreads {
    public static void main(String[] args) {
        System.out.println("=== Alternating Even and Odd Numbers (1 to 20) ===");
        NumberCoordinator coordinator = new NumberCoordinator();

        OddThread oddThread = new OddThread(coordinator);
        EvenThread evenThread = new EvenThread(coordinator);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException ignored) {}

        System.out.println("Finished alternating printing successfully.");
    }
}

