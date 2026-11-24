/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET B - Question 2:
 * Design a Java class named Order to represent an online product order.
 * The class attributes are: customerName, productName, quantity, unitPrice, totalPrice 
 * The program should perform the following operations:
 * a) Accept and store the details of three orders.
 * b) Display a summary of each order, including the total price.
 * c) Determine and display the order with the highest total price.
 * Hint: Use object array
 */

import java.util.Scanner;

class Order {
    // Attributes
    String customerName;
    String productName;
    int quantity;
    double unitPrice;
    double totalPrice;

    // Method to accept order details (No constructor used)
    void acceptOrder(Scanner sc, int orderNum) {
        System.out.println("\n--- Enter Details for Order " + orderNum + " ---");
        System.out.print("Customer Name : ");
        this.customerName = sc.nextLine();
        System.out.print("Product Name  : ");
        this.productName = sc.nextLine();
        System.out.print("Quantity      : ");
        this.quantity = sc.nextInt();
        System.out.print("Unit Price (₹): ");
        this.unitPrice = sc.nextDouble();
        sc.nextLine(); // consume newline

        // Calculate total price
        this.totalPrice = this.quantity * this.unitPrice;
    }

    // Method to display order summary
    void displayOrder() {
        System.out.printf("%-18s %-18s %-10d %-12.2f %-12.2f\n", 
            customerName, productName, quantity, unitPrice, totalPrice);
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ORDER_COUNT = 3;
        
        // Array of objects (Hint: Use object array)
        Order[] orders = new Order[ORDER_COUNT];

        System.out.println("=== Online Product Order System ===");

        // a) Accept and store details of three orders
        for (int i = 0; i < ORDER_COUNT; i++) {
            orders[i] = new Order(); // Creating instance without custom constructor
            orders[i].acceptOrder(sc, i + 1);
        }

        // b) Display summary of each order, including the total price
        System.out.println("\n" + "=".repeat(75));
        System.out.println("                          ORDERS SUMMARY");
        System.out.println("=".repeat(75));
        System.out.printf("%-18s %-18s %-10s %-12s %-12s\n", 
            "Customer", "Product", "Quantity", "Unit Price", "Total Price");
        System.out.println("-".repeat(75));

        for (int i = 0; i < ORDER_COUNT; i++) {
            orders[i].displayOrder();
        }
        System.out.println("=".repeat(75));

        // c) Determine and display the order with the highest total price
        int maxIndex = 0;
        for (int i = 1; i < ORDER_COUNT; i++) {
            if (orders[i].totalPrice > orders[maxIndex].totalPrice) {
                maxIndex = i;
            }
        }

        System.out.println("\n>>> ORDER WITH THE HIGHEST TOTAL PRICE <<<");
        System.out.println("Customer Name : " + orders[maxIndex].customerName);
        System.out.println("Product Name  : " + orders[maxIndex].productName);
        System.out.println("Quantity      : " + orders[maxIndex].quantity);
        System.out.println("Unit Price    : ₹" + orders[maxIndex].unitPrice);
        System.out.println("Total Amount  : ₹" + orders[maxIndex].totalPrice);

        sc.close();
    }
}

