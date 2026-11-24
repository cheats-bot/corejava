/*
 * Assignment 6: File Handling
 * 
 * SET B - Question 5:
 * Write a Java program that reads data from a file using BufferedReader 
 * and displays only the lines that start with the word "Java".
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterLinesStartingWithJava {
    public static void main(String[] args) {
        String filename = "programming_notes.txt";

        // Setup sample file
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Java is an object-oriented programming language.\n");
            fw.write("Python has a concise and readable syntax.\n");
            fw.write("Java Virtual Machine provides cross-platform execution.\n");
            fw.write("C++ offers manual memory management.\n");
            fw.write("Java packages organize code into namespaces.\n");
        } catch (IOException ignored) {}

        System.out.println("=== Lines starting with 'Java' ===");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("Java")) {
                    System.out.println("-> " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

