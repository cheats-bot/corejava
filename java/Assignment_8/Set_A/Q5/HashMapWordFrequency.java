/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 5:
 * Write a Java program using HashMap to count the frequency of words in a given 
 * sentence and display the result.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapWordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        if (sentence.isEmpty()) {
            System.out.println("Sentence is empty.");
            sc.close();
            return;
        }

        String[] words = sentence.split("\\s+");
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String w : words) {
            String cleanWord = w.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            if (!cleanWord.isEmpty()) {
                wordFrequency.put(cleanWord, wordFrequency.getOrDefault(cleanWord, 0) + 1);
            }
        }

        System.out.println("\n=== Word Frequencies ===");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.printf("%-15s : %d time(s)\n", entry.getKey(), entry.getValue());
        }

        sc.close();
    }
}

