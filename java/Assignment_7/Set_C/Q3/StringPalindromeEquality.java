/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET C - Question 3:
 * Write a program to input two strings from the user. 
 * Check if either of the strings is a palindrome and whether the two strings are equal ignoring case.
 */

import java.util.Scanner;

public class StringPalindromeEquality {

    public static boolean checkPalindrome(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();

        System.out.println("\n=== Palindrome & Equality Analysis ===");
        
        // 1. Check if String 1 is palindrome
        System.out.println("Is String 1 (\"" + s1 + "\") a palindrome? : " + (checkPalindrome(s1) ? "YES" : "NO"));

        // 2. Check if String 2 is palindrome
        System.out.println("Is String 2 (\"" + s2 + "\") a palindrome? : " + (checkPalindrome(s2) ? "YES" : "NO"));

        // 3. Check if either of the strings is a palindrome
        boolean eitherPalindrome = checkPalindrome(s1) || checkPalindrome(s2);
        System.out.println("Is either of the strings a palindrome?   : " + (eitherPalindrome ? "YES" : "NO"));

        // 4. Check if equal ignoring case
        boolean equalIgnoreCase = s1.equalsIgnoreCase(s2);
        System.out.println("Are the two strings equal (ignoring case)? : " + (equalIgnoreCase ? "YES" : "NO"));

        sc.close();
    }
}

