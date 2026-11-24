/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 7:
 * Write a Java program to implement the Runnable interface.
 * a) In the run() method, print numbers from 1 to 10.
 * b) Create a thread inside main() using new Thread(object) and start it.
 */

class NumberPrinter implements Runnable {
    // a) In run() method, print numbers from 1 to 10
    @Override
    public void run() {
        System.out.println("Printing numbers 1 to 10 from thread: " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        System.out.println("\nFinished printing numbers.");
    }
}

public class RunnableThreadDemo {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // b) Create a thread inside main() using new Thread(object) and start it
        Thread thread = new Thread(printer, "PrinterThread");
        thread.start();

        System.out.println("Thread launched from main().");
    }
}

