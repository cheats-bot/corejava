/*
 * Assignment 5: Exception Handling
 * 
 * SET C - Question 1:
 * Create a custom checked exception class named ‘InsufficientFundsException’. 
 * Write a BankAccount class with a withdraw(double amount) method. 
 * This method should check if the withdrawal amount is greater than the current balance. 
 * If it is, it must throw an ‘InsufficientFundsException’. 
 * Write a main method to test this by attempting to withdraw more money than is in the account, 
 * ensuring you handle your custom exception.
 */

// Custom checked exception
class InsufficientFundsException extends Exception {
    private double deficit;

    public InsufficientFundsException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.println("\nAttempting to withdraw: ₹" + amount);
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException("Insufficient funds! Cannot withdraw ₹" + amount 
                + ". Short by ₹" + deficit, deficit);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class CustomExceptionBankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("AC100234", 5000.0);
        System.out.println("Bank Account Created with balance: ₹" + acc.getBalance());

        // Test 1: Valid withdrawal
        try {
            acc.withdraw(2000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // Test 2: Invalid withdrawal exceeding balance
        try {
            acc.withdraw(6000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
            System.out.println("Amount short: ₹" + e.getDeficit());
        }

        System.out.println("\nFinal Account Balance: ₹" + acc.getBalance());
    }
}

