/*
 * Assignment 6: File Handling
 * 
 * SET C - Question 2:
 * Write a Java program to split a large text file into smaller files of equal 
 * number of lines (e.g., 50 lines each, or configurable batch size).
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitFileByLines {
    public static void main(String[] args) {
        String sourceFile = "large_source.txt";
        final int LINES_PER_FILE = 5; // configurable batch size

        // Generate sample source file with 18 lines
        try (FileWriter fw = new FileWriter(sourceFile)) {
            for (int i = 1; i <= 18; i++) {
                fw.write("Sample document record line #" + i + "\n");
            }
        } catch (IOException ignored) {}

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            int fileIndex = 1;
            int lineCounter = 0;
            BufferedWriter writer = null;

            while ((line = reader.readLine()) != null) {
                if (lineCounter % LINES_PER_FILE == 0) {
                    if (writer != null) {
                        writer.close();
                    }
                    String partFileName = "part_" + fileIndex + ".txt";
                    writer = new BufferedWriter(new FileWriter(partFileName));
                    System.out.println("Writing to chunk: " + partFileName);
                    fileIndex++;
                }

                writer.write(line);
                writer.newLine();
                lineCounter++;
            }

            if (writer != null) {
                writer.close();
            }

            System.out.println("Splitting complete! Total " + lineCounter + " lines split into " 
                + (fileIndex - 1) + " files of up to " + LINES_PER_FILE + " lines each.");

        } catch (IOException e) {
            System.out.println("Error splitting file: " + e.getMessage());
        }
    }
}

