/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET C - Question 1:
 * Write a Java program to count the number of words in a string entered by the user. 
 * Use split() method.
 */

import java.util.Scanner;

public class WordCountSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        if (sentence.isEmpty()) {
            System.out.println("Word count: 0");
        } else {
            // Split based on one or more whitespace characters
            String[] words = sentence.split("\\s+");
            System.out.println("Sentence: \"" + sentence + "\"");
            System.out.println("Total word count using split(): " + words.length);
            System.out.println("List of words:");
            for (int i = 0; i < words.length; i++) {
                System.out.println("  [" + (i + 1) + "] " + words[i]);
            }
        }

        sc.close();
    }
}

