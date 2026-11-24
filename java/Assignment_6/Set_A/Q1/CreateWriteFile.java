/*
 * Assignment 6: File Handling
 * 
 * SET A - Question 1:
 * Write a Java program to create a text file named sample.txt and write 
 * a few lines of text into it using FileWriter.
 */

import java.io.FileWriter;
import java.io.IOException;

public class CreateWriteFile {
    public static void main(String[] args) {
        String filename = "sample.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Welcome to Core Java Programming.\n");
            writer.write("File Handling using FileWriter is straightforward.\n");
            writer.write("This file was generated for Lab Practical Assignment 6.\n");
            System.out.println("Successfully created and wrote text to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred during file writing: " + e.getMessage());
        }
    }
}

