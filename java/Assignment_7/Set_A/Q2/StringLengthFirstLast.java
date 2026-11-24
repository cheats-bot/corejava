/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET A - Question 2:
 * Write a Java program to input a string from the user and display:
 * a) Its length
 * b) The first and last characters
 */

import java.util.Scanner;

public class StringLengthFirstLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("The entered string is empty.");
        } else {
            System.out.println("String entered          : \"" + str + "\"");
            System.out.println("a) Length of the string : " + str.length());
            System.out.println("b) First character      : '" + str.charAt(0) + "'");
            System.out.println("   Last character       : '" + str.charAt(str.length() - 1) + "'");
        }

        sc.close();
    }
}

