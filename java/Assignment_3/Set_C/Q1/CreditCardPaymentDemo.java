/*
 * Assignment 3: Abstract Classes & Interfaces
 * 
 * SET C - Question 1:
 * Create an abstract class Payment(amount, balance, duedate) with a method makePayment() 
 * and an interface Auth with method boolean authenticate(String username, String password). 
 * Implement both in a class CreditCardPayment. Check and enforce the following transaction rules:
 * a) Transaction Limit: Maximum allowed transaction is ₹10,000
 * b) Minimum Balance Requirement: User account must retain at least ₹1,000 after payment
 * c) Timely Payment Requirement: If payment is not made within the due date, a fine of ₹200 is added
 * 
 * Perform the following operations:
 * a) Authenticate the user
 * b) Accept the payment amount and current account balance
 * c) Accept the number of days past due (0 if on time)
 * d) Verify transaction limits and balance requirements
 * e) Apply fine if overdue
 * f) Display appropriate messages:
 *    i) Authentication success/failure
 *    ii) Payment success/failure (due to limit or insufficient balance)
 *    iii) Fine applied (if applicable)
 */

import java.util.Scanner;

// Interface for authentication
interface Auth {
    boolean authenticate(String username, String password);
}

// Abstract class Payment
abstract class Payment {
    protected double amount;
    protected double balance;
    protected int daysPastDue;

    public Payment(double amount, double balance, int daysPastDue) {
        this.amount = amount;
        this.balance = balance;
        this.daysPastDue = daysPastDue;
    }

    public abstract void makePayment();
}

// Concrete class extending Payment and implementing Auth
class CreditCardPayment extends Payment implements Auth {
    private static final String VALID_USER = "carduser";
    private static final String VALID_PASS = "pass123";
    private static final double MAX_TRANSACTION_LIMIT = 10000.0;
    private static final double MIN_BALANCE_REQUIRED = 1000.0;
    private static final double LATE_FINE = 200.0;

    public CreditCardPayment(double amount, double balance, int daysPastDue) {
        super(amount, balance, daysPastDue);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return VALID_USER.equals(username) && VALID_PASS.equals(password);
    }

    @Override
    public void makePayment() {
        System.out.println("\n--- Processing Transaction ---");

        // Rule a: Transaction Limit Check
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("❌ Payment Failed: Transaction amount (₹" + amount 
                + ") exceeds the maximum allowed limit of ₹" + MAX_TRANSACTION_LIMIT);
            return;
        }

        // Rule c: Timely Payment Requirement Check
        double totalDeduction = amount;
        if (daysPastDue > 0) {
            totalDeduction += LATE_FINE;
            System.out.println("⚠️ Fine Applied: Overdue by " + daysPastDue + " day(s). Late fine of ₹" + LATE_FINE + " added.");
        } else {
            System.out.println("ℹ️ On-time payment: No late fine applied.");
        }

        // Rule b: Minimum Balance Requirement Check
        if ((balance - totalDeduction) < MIN_BALANCE_REQUIRED) {
            System.out.printf("❌ Payment Failed: Insufficient funds! Account must retain at least ₹%.2f. Needed: ₹%.2f, Available: ₹%.2f\n",
                MIN_BALANCE_REQUIRED, totalDeduction, balance);
            return;
        }

        // Execute payment
        balance -= totalDeduction;
        System.out.println("✅ Payment Successful!");
        System.out.printf("   Amount Paid      : ₹%.2f\n", amount);
        if (daysPastDue > 0) {
            System.out.printf("   Fine Paid        : ₹%.2f\n", LATE_FINE);
        }
        System.out.printf("   Remaining Balance: ₹%.2f\n", balance);
    }
}

public class CreditCardPaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("           CREDIT CARD PAYMENT SYSTEM             ");
        System.out.println("==================================================");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        System.out.print("Enter Current Account Balance (₹): ");
        double balance = sc.nextDouble();
        System.out.print("Enter Payment Amount (₹): ");
        double amount = sc.nextDouble();
        System.out.print("Enter Days Past Due (0 if on time): ");
        int days = sc.nextInt();

        CreditCardPayment payment = new CreditCardPayment(amount, balance, days);

        // a) Authenticate user
        if (payment.authenticate(user, pass)) {
            System.out.println("\n✅ Authentication Successful. Welcome, " + user + "!");
            // d, e, f) Process payment & verify rules
            payment.makePayment();
        } else {
            System.out.println("\n❌ Authentication Failed: Invalid credentials. Access Denied.");
        }

        sc.close();
    }
}

