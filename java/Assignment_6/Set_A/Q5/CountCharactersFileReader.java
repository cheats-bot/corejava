/*
 * Assignment 6: File Handling
 * 
 * SET A - Question 5:
 * Write a Java program that reads a text file character by character using FileReader 
 * and counts the total number of characters.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountCharactersFileReader {
    public static void main(String[] args) {
        String filename = "char_count.txt";

        // Setup sample file
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Count characters test string.\nJava 2025-26.");
        } catch (IOException ignored) {}

        int charCount = 0;
        try (FileReader fr = new FileReader(filename)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                charCount++;
            }
            System.out.println("File: " + filename);
            System.out.println("Total number of characters in file: " + charCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

