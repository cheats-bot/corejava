/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET B - Question 3:
 * Write a Java program to input a string and a character from the user. 
 * Check whether the character is present in the string and display its first index.
 */

import java.util.Scanner;

public class CharSearchInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter a character to search: ");
        char ch = sc.next().charAt(0);

        int index = str.indexOf(ch);

        if (index != -1) {
            System.out.println("Character '" + ch + "' is PRESENT in \"" + str + "\" at first index: " + index);
        } else {
            System.out.println("Character '" + ch + "' is NOT PRESENT in \"" + str + "\".");
        }

        sc.close();
    }
}

