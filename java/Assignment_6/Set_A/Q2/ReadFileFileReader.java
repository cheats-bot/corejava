/*
 * Assignment 6: File Handling
 * 
 * SET A - Question 2:
 * Write a Java program to read the contents of a text file using FileReader 
 * and display them on the console.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileFileReader {
    public static void main(String[] args) {
        String filename = "sample.txt";

        // Ensuring file exists for test
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Reading file contents using FileReader in Java.\nLine 2: Character streams.\n");
        } catch (IOException ignored) {}

        try (FileReader reader = new FileReader(filename)) {
            int character;
            System.out.println("Contents of '" + filename + "':\n---------------------------------");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("---------------------------------");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

