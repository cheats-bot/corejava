/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 5:
 * Implement the Producer–Consumer Problem using:
 * a) wait()
 * b) notify()
 * c) A shared buffer of size 1
 * d) Specifications:
 *    • Producer thread produces numbers 1 to 5.
 *    • Consumer thread consumes them.
 *    • Producer should wait if buffer is FULL.
 *    • Consumer should wait if buffer is EMPTY.
 *    • Use proper messages:
 *      - "Producer produced: X"
 *      - "Consumer consumed: X"
 *      - "Buffer full, producer waiting..."
 *      - "Buffer empty, consumer waiting..."
 */

class SharedBuffer {
    private int data;
    private boolean hasData = false; // Buffer of size 1

    // Synchronized produce method
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                System.out.println("Buffer full, producer waiting...");
                wait(); // wait if buffer is FULL
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.data = value;
        hasData = true;
        System.out.println("Producer produced: " + value);
        notify(); // notify consumer that data is available
    }

    // Synchronized consume method
    public synchronized int consume() {
        while (!hasData) {
            try {
                System.out.println("Buffer empty, consumer waiting...");
                wait(); // wait if buffer is EMPTY
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int value = this.data;
        hasData = false;
        System.out.println("Consumer consumed: " + value);
        notify(); // notify producer that buffer is empty
        return value;
    }
}

class ProducerTask implements Runnable {
    private SharedBuffer buffer;

    public ProducerTask(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(400); // 400ms delay between productions
            } catch (InterruptedException ignored) {}
        }
    }
}

class ConsumerTask implements Runnable {
    private SharedBuffer buffer;

    public ConsumerTask(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(600); // 600ms delay between consumptions
            } catch (InterruptedException ignored) {}
        }
    }
}

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        System.out.println("=== Producer-Consumer (Buffer Size 1 using wait/notify) ===");
        SharedBuffer buffer = new SharedBuffer();

        Thread producerThread = new Thread(new ProducerTask(buffer), "Producer");
        Thread consumerThread = new Thread(new ConsumerTask(buffer), "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ignored) {}

        System.out.println("Producer and Consumer finished execution successfully.");
    }
}

