/*
 * Assignment 5: Exception Handling
 * 
 * SET A - Question 1:
 * Create a Calculator class with a method to divide two integers. 
 * Handle division by zero with an appropriate message.
 */

import java.util.Scanner;

class Calculator {
    public void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + a + " / " + b + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not permitted in arithmetic (" + e.getMessage() + ").");
        }
    }
}

public class DivisionHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("=== Calculator Division with Exception Handling ===");
        System.out.print("Enter numerator: ");
        int num = sc.nextInt();
        System.out.print("Enter denominator: ");
        int den = sc.nextInt();

        calc.divide(num, den);

        sc.close();
    }
}

