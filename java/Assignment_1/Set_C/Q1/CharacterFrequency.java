/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET C - Question 1:
 * Write a program to input a string and display the frequency of each character.
 * Ignore spaces and consider case-insensitive comparison.
 * Example:
 * Input: Java → Output: J:1, A:2, V:1
 */

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void displayFrequency(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Input string is empty.");
            return;
        }

        // Using LinkedHashMap to maintain order of character appearance
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Ignore spaces
            if (Character.isWhitespace(ch)) {
                continue;
            }

            // Case-insensitive comparison: convert to upper-case (as shown in Example: Java -> J:1, A:2, V:1)
            char upperChar = Character.toUpperCase(ch);

            freqMap.put(upperChar, freqMap.getOrDefault(upperChar, 0) + 1);
        }

        // Format and print output
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (count > 0) {
                output.append(", ");
            }
            output.append(entry.getKey()).append(":").append(entry.getValue());
            count++;
        }

        System.out.println("Output: " + output.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        displayFrequency(str);

        sc.close();
    }
}

