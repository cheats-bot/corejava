/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET B - Question 1:
 * Develop a Java program that checks whether a given string or number is a palindrome. 
 * A palindrome is a sequence that reads the same backward as forward.
 * a) For strings, ignore case and spaces
 * b) For numbers, reverse the digits and compare
 * Use method overloading or conditional logic to handle both data types.
 */

import java.util.Scanner;

public class PalindromeChecker {

    // Overloaded method to check palindrome for a String
    // Requirement: Ignore case and spaces
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        
        // Remove spaces and convert to lower case
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Overloaded method to check palindrome for a Number
    // Requirement: Reverse the digits and compare
    public static boolean isPalindrome(long num) {
        if (num < 0) {
            // Negative numbers are generally not palindromes due to minus sign
            return false;
        }
        long original = num;
        long reversed = 0;

        while (num > 0) {
            long rem = num % 10;
            reversed = reversed * 10 + rem;
            num /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== PALINDROME CHECKER =====");
            System.out.println("1. Check Palindrome for a String (ignores case & spaces)");
            System.out.println("2. Check Palindrome for a Number (reverses digits)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String text = sc.nextLine();
                    if (isPalindrome(text)) {
                        System.out.println("\"" + text + "\" IS a palindrome.");
                    } else {
                        System.out.println("\"" + text + "\" is NOT a palindrome.");
                    }
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    if (sc.hasNextLong()) {
                        long number = sc.nextLong();
                        if (isPalindrome(number)) {
                            System.out.println(number + " IS a palindrome number.");
                        } else {
                            System.out.println(number + " is NOT a palindrome number.");
                        }
                    } else {
                        System.out.println("Invalid number format.");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Choose 1, 2, or 3.");
            }

        } while (choice != 3);

        sc.close();
    }
}

