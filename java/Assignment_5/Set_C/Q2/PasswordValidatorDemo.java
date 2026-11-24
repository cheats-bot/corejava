/*
 * Assignment 5: Exception Handling
 * 
 * SET C - Question 2:
 * Write a Java program that validates a user's password based on a simple rule.
 * i) Create a method void validatePassword(String password).
 * ii) Inside this method, check if the password's length is less than 8 characters.
 * iii) If the length is less than 8, the method must throw a custom exception 
 *      ‘InvalidPasswordException’ with the message "Password must be at least 8 characters long."
 * iv) If the password is valid, it should print "Password is valid."
 * v) In the main method, prompt the user to enter a password. Call the validatePassword 
 *    method from within a try-catch block and gracefully handle the ‘InvalidPasswordException’ 
 *    by printing the error message to the console.
 */

import java.util.Scanner;

// Custom exception
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidatorDemo {

    // Method to validate password
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        System.out.println("✅ Password is valid.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password to validate: ");
        String pass = sc.nextLine();

        try {
            validatePassword(pass);
        } catch (InvalidPasswordException e) {
            System.out.println("❌ InvalidPasswordException Caught: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

