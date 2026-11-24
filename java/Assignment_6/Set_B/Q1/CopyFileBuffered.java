/*
 * Assignment 6: File Handling
 * 
 * SET B - Question 1:
 * Write a Java program to copy the contents of one file into another file 
 * using BufferedReader and BufferedWriter.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileBuffered {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        // Prepare source file
        try (FileWriter fw = new FileWriter(sourceFile)) {
            fw.write("Source File: This content will be copied to destination.\nSecond line of source file.");
        } catch (IOException ignored) {}

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File copied successfully from '" + sourceFile + "' to '" + destFile + "'.");

        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}

