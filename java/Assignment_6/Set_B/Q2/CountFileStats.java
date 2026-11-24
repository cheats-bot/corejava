/*
 * Assignment 6: File Handling
 * 
 * SET B - Question 2:
 * Write a Java program to read a text file and count the number of lines, words, and characters.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountFileStats {
    public static void main(String[] args) {
        String filename = "stats_sample.txt";

        // Setup sample file
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Java is a high-level programming language.\n");
            fw.write("It was developed by Sun Microsystems.\n");
            fw.write("Java supports multi-threading and robust memory management.\n");
        } catch (IOException ignored) {}

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length(); // characters excluding newline
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("=== File Statistics for '" + filename + "' ===");
            System.out.println("Total Lines      : " + lineCount);
            System.out.println("Total Words      : " + wordCount);
            System.out.println("Total Characters : " + charCount);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}

