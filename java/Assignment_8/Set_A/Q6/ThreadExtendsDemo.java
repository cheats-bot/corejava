/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 6:
 * Write a Java program to create a class MyThread that extends the Thread class.
 * a) Override the run() method to print your name 5 times.
 * b) In the main() method, create an object of MyThread and start the thread using start().
 */

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    // a) Override the run() method
    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Thread started executing.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + i + "] Hello, my name is " + name);
            try {
                Thread.sleep(400); // 400ms pause
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Thread finished.");
    }
}

public class ThreadExtendsDemo {
    public static void main(String[] args) {
        System.out.println("Main thread: Launching MyThread...");

        // b) In main, create an object and start thread using start()
        MyThread t1 = new MyThread("Suraj");
        t1.setName("Worker-Suraj");
        t1.start(); // invokes run() asynchronously

        System.out.println("Main thread: Started worker thread.");
    }
}

