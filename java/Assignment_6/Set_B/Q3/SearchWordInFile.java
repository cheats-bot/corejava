/*
 * Assignment 6: File Handling
 * 
 * SET B - Question 3:
 * Write a Java program to read a file and search for a given word entered by the user. 
 * Display the number of times the word occurs.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchWordInFile {
    public static void main(String[] args) {
        String filename = "search_text.txt";

        // Prepare file
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Java is versatile. Learning Java helps understand object oriented principles. Java is platform independent.\n");
        } catch (IOException ignored) {}

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word to search in file: ");
        String searchWord = sc.next();

        int occurrences = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by non-word characters
                String[] words = line.split("[^a-zA-Z0-9_]+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(searchWord)) {
                        occurrences++;
                    }
                }
            }
            System.out.println("The word '" + searchWord + "' appeared " + occurrences + " time(s) in '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

