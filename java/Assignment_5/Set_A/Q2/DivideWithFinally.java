/*
 * Assignment 5: Exception Handling
 * 
 * SET A - Question 2:
 * Write a program that takes two integers from the user and divides them. 
 * Handle the ‘ArithmeticException’ if the denominator is zero by printing an error message. 
 * Use a finally block to display a message indicating that the program execution is complete.
 */

import java.util.Scanner;

public class DivideWithFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first integer (dividend): ");
            int a = sc.nextInt();
            System.out.print("Enter second integer (divisor): ");
            int b = sc.nextInt();

            int quotient = a / b;
            System.out.println("Quotient: " + a + " / " + b + " = " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: Denominator cannot be zero! (" + e.getMessage() + ")");
        } finally {
            System.out.println("[finally block]: Program execution is complete. Cleaned up resources.");
            sc.close();
        }
    }
}

