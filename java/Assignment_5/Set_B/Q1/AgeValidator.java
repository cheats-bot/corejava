/*
 * Assignment 5: Exception Handling
 * 
 * SET B - Question 1:
 * Write a method validateAge(int age) that checks if the given age is less than 18. 
 * If it is, the method should throw an ‘ArithmeticException’ with the message 
 * "Access denied - You must be at least 18 years old." In the main method, call 
 * validateAge() inside a try-catch block and handle the thrown exception.
 */

import java.util.Scanner;

public class AgeValidator {

    // Method that validates age and throws ArithmeticException if under 18
    public static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are eligible to vote / register!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int userAge = sc.nextInt();

        try {
            validateAge(userAge);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught in main: " + e.getMessage());
        } finally {
            System.out.println("Age verification check finished.");
            sc.close();
        }
    }
}

