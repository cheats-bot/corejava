/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 4:
 * Write a Java program to accept a list of student names. Perform the following:
 * a) Remove duplicates.
 * b) Display names in alphabetical order.
 * c) Allow searching for a given name.
 * Hint: Choose a collection that automatically sorts elements and ensures uniqueness.
 */

import java.util.Scanner;
import java.util.TreeSet;

public class StudentNameSetSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TreeSet guarantees both uniqueness (no duplicates) and sorted order
        TreeSet<String> students = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.print("How many names would you like to enter? ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter student name #" + i + ": ");
            String name = sc.nextLine().trim();
            students.add(name); // Duplicates automatically eliminated
        }

        // b) Display in alphabetical order
        System.out.println("\n=== Unique Student Names in Alphabetical Order ===");
        for (String name : students) {
            System.out.println("-> " + name);
        }

        // c) Search for a name
        System.out.print("\nEnter a student name to search: ");
        String query = sc.nextLine().trim();

        if (students.contains(query)) {
            System.out.println("✅ Student \"" + query + "\" is enrolled in the list.");
        } else {
            System.out.println("❌ Student \"" + query + "\" was NOT found in the list.");
        }

        sc.close();
    }
}

