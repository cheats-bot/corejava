/*
 * Assignment 6: File Handling
 * 
 * SET C - Question 1:
 * Write a Java program to merge the contents of two text files into a third file.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String mergedFile = "merged_output.txt";

        // Setup file 1
        try (FileWriter fw = new FileWriter(file1)) {
            fw.write("--- Content from File 1 ---\nFirst file data line A.\nFirst file data line B.\n");
        } catch (IOException ignored) {}

        // Setup file 2
        try (FileWriter fw = new FileWriter(file2)) {
            fw.write("--- Content from File 2 ---\nSecond file data line X.\nSecond file data line Y.\n");
        } catch (IOException ignored) {}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFile));
             BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String line;
            // Write contents of file 1
            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            // Write contents of file 2
            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Merged '" + file1 + "' and '" + file2 + "' into '" + mergedFile + "' successfully.");

        } catch (IOException e) {
            System.out.println("Error merging files: " + e.getMessage());
        }

        // Display merged contents
        try (BufferedReader br = new BufferedReader(new FileReader(mergedFile))) {
            System.out.println("\nMerged File Contents:\n=====================");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ignored) {}
    }
}

