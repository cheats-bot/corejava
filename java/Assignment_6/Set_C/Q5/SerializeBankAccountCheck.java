/*
 * Assignment 6: File Handling
 * 
 * SET C - Question 5:
 * Write a Java program to serialize a BankAccount(accNo, accHolderName, balance) object. 
 * Use exception handling to prevent serialization if the balance is negative.
 */

import java.io.*;

// Custom exception for negative balance
class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accNo;
    private String accHolderName;
    private double balance;

    public BankAccount(String accNo, String accHolderName, double balance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void display() {
        System.out.println("Account Number : " + accNo);
        System.out.println("Holder Name    : " + accHolderName);
        System.out.printf("Balance        : ₹%.2f\n", balance);
    }
}

public class SerializeBankAccountCheck {

    public static void serializeAccount(BankAccount acc, String filename) throws NegativeBalanceException, IOException {
        if (acc.getBalance() < 0) {
            throw new NegativeBalanceException("Serialization Rejected: Account balance is negative (₹" + acc.getBalance() + ")!");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(acc);
            System.out.println("✅ Account serialized successfully to '" + filename + "'.");
        }
    }

    public static void main(String[] args) {
        String filename = "bank_account.ser";

        BankAccount validAcc = new BankAccount("SB1001", "Ramesh Joshi", 4500.0);
        BankAccount invalidAcc = new BankAccount("SB1002", "Negative Balance User", -1200.0);

        // Case 1: Valid Account
        System.out.println("--- Case 1: Valid Account Serialization ---");
        validAcc.display();
        try {
            serializeAccount(validAcc, filename);
        } catch (NegativeBalanceException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Case 2: Negative Balance Account
        System.out.println("\n--- Case 2: Negative Balance Account Serialization ---");
        invalidAcc.display();
        try {
            serializeAccount(invalidAcc, filename);
        } catch (NegativeBalanceException e) {
            System.out.println("❌ Caught NegativeBalanceException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}

