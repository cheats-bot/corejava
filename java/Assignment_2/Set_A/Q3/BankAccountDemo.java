/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET A - Question 3:
 * Create a class BankAccount with attributes: account number, holder name, and balance. 
 * Implement methods for deposit, withdrawal, and displaying account details. 
 * Use access modifiers and ensure balance cannot be modified directly from outside the class.
 */

import java.util.Scanner;

class BankAccount {
    // Private attributes to ensure encapsulation (balance cannot be directly modified outside)
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance! Current balance: ₹" + balance);
        } else {
            this.balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        }
    }

    // Getter for balance (read-only)
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.printf("Current Balance: ₹%.2f\n", balance);
        System.out.println("----------------------------------------");
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Open New Bank Account ===");
        System.out.print("Enter Account Number : ");
        String accNo = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit Amount: ");
        double initialBal = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, initialBal);

        int choice;
        do {
            System.out.println("\n--- Bank Operations ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance & Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    break;
                case 3:
                    account.displayAccountDetails();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}

