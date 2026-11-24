/*
 * Assignment 5: Exception Handling
 * 
 * SET B - Question 2:
 * Write a program that creates an integer array. Ask the user for an index and a divisor. 
 * Inside a try block, attempt to access the array element at the given index and divide it 
 * by the given divisor. Add separate catch blocks for ‘ArrayIndexOutOfBoundsException’, 
 * ‘ArithmeticException’, and a general Exception to handle any other errors. 
 * Print a specific message for each type of exception.
 */

import java.util.Scanner;

public class ArrayDivisionExceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {100, 200, 300, 400, 500};

        System.out.println("Array elements: [100, 200, 300, 400, 500] (Indices 0 to 4)");

        try {
            System.out.print("Enter array index to access (0-4): ");
            int index = sc.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            int element = numbers[index]; // Can throw ArrayIndexOutOfBoundsException
            int result = element / divisor; // Can throw ArithmeticException

            System.out.println("Result: numbers[" + index + "] / " + divisor + " = " 
                + element + " / " + divisor + " = " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error [ArrayIndexOutOfBoundsException]: The specified index is outside the bounds of the array! (" + e.getMessage() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Error [ArithmeticException]: Cannot divide by zero! (" + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("Error [General Exception]: An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Program terminated safely.");
            sc.close();
        }
    }
}

