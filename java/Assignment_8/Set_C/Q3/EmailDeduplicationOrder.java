/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 3:
 * Write a Java program to read a list of email addresses and:
 * a) Identify duplicates.
 * b) Display only the unique email addresses.
 * c) Preserve the order of first occurrence.
 * 
 * Hint: Think about how to maintain insertion order while ensuring uniqueness.
 */

import java.util.*;

public class EmailDeduplicationOrder {
    public static void main(String[] args) {
        // Sample list containing duplicated email addresses
        List<String> emailList = Arrays.asList(
            "student1@college.edu",
            "faculty@college.edu",
            "student2@college.edu",
            "student1@college.edu", // duplicate
            "admin@college.edu",
            "faculty@college.edu",  // duplicate
            "library@college.edu",
            "student2@college.edu"  // duplicate
        );

        System.out.println("Input Email List (" + emailList.size() + " items):");
        for (int i = 0; i < emailList.size(); i++) {
            System.out.println("  [" + (i + 1) + "] " + emailList.get(i));
        }

        // LinkedHashSet maintains insertion order while rejecting duplicates
        Set<String> uniqueEmails = new LinkedHashSet<>();
        Set<String> duplicateEmails = new LinkedHashSet<>();

        for (String email : emailList) {
            if (!uniqueEmails.add(email)) {
                // Already in set -> duplicate
                duplicateEmails.add(email);
            }
        }

        // a) Identify duplicates
        System.out.println("\n=== a) Identified Duplicate Emails ===");
        for (String dup : duplicateEmails) {
            System.out.println("⚠️ Duplicate found: " + dup);
        }

        // b & c) Display unique email addresses preserving order of first occurrence
        System.out.println("\n=== b & c) Unique Emails (Preserving First Occurrence Order) ===");
        int count = 1;
        for (String email : uniqueEmails) {
            System.out.println("  " + count++ + ". " + email);
        }
    }
}

