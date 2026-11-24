/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 6:
 * Create a class Counter with a variable count. (Use synchronization)
 * a) Create two threads that increment the count 1000 times each.
 * b) Print final value of count.
 */

class Counter {
    private int count = 0;

    // Synchronized method to prevent race conditions
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
        System.out.println(getName() + " finished 1000 increments.");
    }
}

public class SynchronizedCounterDemo {
    public static void main(String[] args) {
        System.out.println("=== Synchronized Counter Demo ===");
        Counter sharedCounter = new Counter();

        // Two threads sharing the same Counter object
        CounterThread thread1 = new CounterThread(sharedCounter, "Thread-1");
        CounterThread thread2 = new CounterThread(sharedCounter, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        // Expected count = 1000 + 1000 = 2000
        System.out.println("\nExpected Count : 2000");
        System.out.println("Actual Count   : " + sharedCounter.getCount());
        if (sharedCounter.getCount() == 2000) {
            System.out.println("✅ Synchronization successful! No race condition occurred.");
        }
    }
}

