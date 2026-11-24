/*
 * Assignment 5: Exception Handling
 * 
 * SET A - Question 3:
 * Write a Java program to read a string input from the user and attempt to convert 
 * it to an integer. If the input is invalid, catch ‘NumberFormatException’ and display an error message.
 */

import java.util.Scanner;

public class StringToIntegerFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a numerical string to parse into an integer: ");
        String input = sc.nextLine();

        try {
            int parsedInt = Integer.parseInt(input);
            System.out.println("Success! Converted value is: " + parsedInt);
            System.out.println("Square of the integer: " + (parsedInt * parsedInt));
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + input + "' is not a valid integer! NumberFormatException caught.");
        } finally {
            sc.close();
        }
    }
}

