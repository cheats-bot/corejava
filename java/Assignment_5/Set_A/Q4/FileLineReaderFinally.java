/*
 * Assignment 5: Exception Handling
 * 
 * SET A - Question 4:
 * Write a Java program to read a line by line file. 
 * Handle IOException and ensure the file is closed using finally.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileLineReaderFinally {
    public static void main(String[] args) {
        String filename = "test_input.txt";

        // Create a dummy file first so the read operation has sample data
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Line 1: Core Java Programming\nLine 2: Department of Computer Science\nLine 3: Exception Handling Demo\n");
        } catch (IOException e) {
            System.out.println("Error creating initial file: " + e.getMessage());
        }

        BufferedReader reader = null;
        try {
            System.out.println("Reading contents of '" + filename + "' line by line:\n---");
            reader = new BufferedReader(new FileReader(filename));
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + lineNum++ + "] " + line);
            }
        } catch (IOException e) {
            System.out.println("IOException occurred while reading file: " + e.getMessage());
        } finally {
            // Ensuring the file reader is properly closed in finally
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("---\n[finally block]: BufferedReader closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}

