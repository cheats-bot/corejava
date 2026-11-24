/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET B - Question 5:
 * Write a Java program to input a string from the user and display:
 * a) Uppercase and lowercase versions
 * b) Trimmed string
 * c) String after replacing all spaces with underscores
 */

import java.util.Scanner;

public class StringTransformations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string (try with leading/trailing spaces): ");
        String input = sc.nextLine();

        System.out.println("\n=== String Transformation Results ===");
        System.out.println("Original String  : \"" + input + "\"");
        System.out.println("a) Uppercase     : \"" + input.toUpperCase() + "\"");
        System.out.println("   Lowercase     : \"" + input.toLowerCase() + "\"");
        System.out.println("b) Trimmed       : \"" + input.trim() + "\"");
        System.out.println("c) Underscores   : \"" + input.replace(' ', '_') + "\"");

        sc.close();
    }
}

