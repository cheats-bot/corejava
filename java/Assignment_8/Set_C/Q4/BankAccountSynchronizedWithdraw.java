/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 4:
 * Create a class BankAccount with balance = 10000.
 * a) Two threads try to withdraw ₹7000 each.
 * b) Use a synchronized block to ensure only one thread can withdraw at a time.
 * c) Print:
 *    i) Remaining balance
 *    ii) Whether withdrawal was successful
 *    iii) Thread execution messages
 */

class BankAccount {
    private double balance = 10000.0;
    // Lock object for synchronized block
    private final Object lock = new Object();

    public void withdraw(double amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Arrived at bank counter, attempting to withdraw ₹" + amount);

        // b) Synchronized block
        synchronized (lock) {
            System.out.println(">>> [" + threadName + "] Entered synchronized critical section.");
            System.out.println("    Current balance available: ₹" + balance);

            if (balance >= amount) {
                System.out.println("    [" + threadName + "] Sufficient balance confirmed. Dispensing ₹" + amount + "...");
                try {
                    Thread.sleep(500); // Simulate processing time
                } catch (InterruptedException ignored) {}

                balance -= amount;
                System.out.println("    ✅ [" + threadName + "] WITHDRAWAL SUCCESSFUL!");
                System.out.println("    Remaining Balance: ₹" + balance);
            } else {
                System.out.println("    ❌ [" + threadName + "] WITHDRAWAL FAILED: Insufficient funds!");
                System.out.println("    Requested: ₹" + amount + ", but Remaining Balance is only ₹" + balance);
            }
            System.out.println("<<< [" + threadName + "] Exited synchronized block.\n");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;

    public WithdrawalThread(BankAccount account, String threadName, double amount) {
        super(threadName);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankAccountSynchronizedWithdraw {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    SYNCHRONIZED WITHDRAWAL CONCURRENCY DEMO      ");
        System.out.println("==================================================");

        BankAccount account = new BankAccount();
        System.out.println("Initial Account Balance: ₹" + account.getBalance());

        // a) Two threads try to withdraw ₹7000 each
        WithdrawalThread t1 = new WithdrawalThread(account, "Thread-1 (ATM-1)", 7000.0);
        WithdrawalThread t2 = new WithdrawalThread(account, "Thread-2 (ATM-2)", 7000.0);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}

        System.out.println("==================================================");
        System.out.println("Final Account Balance: ₹" + account.getBalance());
        System.out.println("==================================================");
    }
}

