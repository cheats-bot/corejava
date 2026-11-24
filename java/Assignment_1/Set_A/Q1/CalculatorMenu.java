/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET A - Question 1:
 * Design a console-based application where a user is repeatedly presented with 
 * a menu for operations like addition, subtraction, multiplication, and division. 
 * Based on user selection, prompt for input values and perform the operation. 
 * Allow the user to continue or exit.
 */

import java.util.Scanner;

public class CalculatorMenu {

    // Method to perform addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method to perform subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method to perform multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method to perform division
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorMenu calc = new CalculatorMenu();
        int choice;

        do {
            System.out.println("\n========== CALCULATOR MENU ==========");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + calc.add(num1, num2));
                        break;
                    case 2:
                        System.out.println("Result: " + num1 + " - " + num2 + " = " + calc.subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println("Result: " + num1 + " * " + num2 + " = " + calc.multiply(num1, num2));
                        break;
                    case 4:
                        double divResult = calc.divide(num1, num2);
                        if (!Double.isNaN(divResult)) {
                            System.out.println("Result: " + num1 + " / " + num2 + " = " + divResult);
                        }
                        break;
                }
            } else if (choice == 5) {
                System.out.println("Exiting application. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please select an option from 1 to 5.");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            char cont = sc.next().charAt(0);
            if (cont == 'n' || cont == 'N') {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

        } while (true);

        sc.close();
    }
}

