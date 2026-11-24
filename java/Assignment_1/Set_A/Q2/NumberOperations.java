/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET A - Question 2:
 * Create a menu-driven program in Java with options:
 * a) 1: Find factorial
 * b) 2: Check prime
 * c) 3: Check perfect number
 * d) 4: Exit
 * Use switch statement and methods for each option.
 */

import java.util.Scanner;

public class NumberOperations {

    // Method to calculate factorial of a number
    public static long findFactorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is prime
    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a perfect number
    // (A perfect number is a positive integer equal to the sum of its positive proper divisors)
    public static boolean checkPerfectNumber(int n) {
        if (n <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1: Find factorial");
            System.out.println("2: Check prime");
            System.out.println("3: Check perfect number");
            System.out.println("4: Exit");
            System.out.print("Enter your choice (1-4): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a positive integer: ");
                    int numFact = sc.nextInt();
                    long factResult = findFactorial(numFact);
                    if (factResult != -1) {
                        System.out.println("Factorial of " + numFact + " is: " + factResult);
                    }
                    break;

                case 2:
                    System.out.print("Enter an integer to check prime: ");
                    int numPrime = sc.nextInt();
                    if (checkPrime(numPrime)) {
                        System.out.println(numPrime + " is a Prime number.");
                    } else {
                        System.out.println(numPrime + " is NOT a Prime number.");
                    }
                    break;

                case 3:
                    System.out.print("Enter an integer to check perfect number: ");
                    int numPerf = sc.nextInt();
                    if (checkPerfectNumber(numPerf)) {
                        System.out.println(numPerf + " is a Perfect number.");
                    } else {
                        System.out.println(numPerf + " is NOT a Perfect number.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please select between 1 and 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}

