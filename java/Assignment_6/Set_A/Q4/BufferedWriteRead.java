/*
 * Assignment 6: File Handling
 * 
 * SET A - Question 4:
 * Write a Java program that uses BufferedWriter to write multiple lines into a file 
 * and then read the file contents using BufferedReader.
 */

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class BufferedWriteRead {
    public static void main(String[] args) {
        String filename = "buffered_demo.txt";

        // 1. Writing multiple lines using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Line 1: High-performance buffered I/O.");
            bw.newLine();
            bw.write("Line 2: Buffered writing is efficient for large text streams.");
            bw.newLine();
            bw.write("Line 3: Java Collections and Streams complement I/O.");
            bw.newLine();
            System.out.println("Successfully written multiple lines using BufferedWriter.");
        } catch (IOException e) {
            System.out.println("Error writing with BufferedWriter: " + e.getMessage());
        }

        // 2. Reading contents using BufferedReader
        System.out.println("\nReading contents line-by-line using BufferedReader:");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("[Row " + count++ + "] " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading with BufferedReader: " + e.getMessage());
        }
    }
}

