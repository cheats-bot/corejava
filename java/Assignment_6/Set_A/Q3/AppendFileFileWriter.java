/*
 * Assignment 6: File Handling
 * 
 * SET A - Question 3:
 * Write a Java program to append text to an existing file using FileWriter in append mode.
 */

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class AppendFileFileWriter {
    public static void main(String[] args) {
        String filename = "append_demo.txt";

        // First write
        try (FileWriter fw = new FileWriter(filename, false)) {
            fw.write("Original line 1: Initial file creation.\n");
        } catch (IOException ignored) {}

        // Append mode: true enables appending to existing contents
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Appended line 2: Added using FileWriter(filename, true).\n");
            writer.write("Appended line 3: Timestamp logged successfully.\n");
            System.out.println("Text successfully appended to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }

        // Print final contents
        try (FileReader fr = new FileReader(filename)) {
            System.out.println("\nFinal File Contents:\n---");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println("---");
        } catch (IOException ignored) {}
    }
}

