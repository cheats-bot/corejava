/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 2:
 * Write a Java program using TreeSet to automatically store and display names in alphabetical order.
 */

import java.util.TreeSet;

public class TreeSetNames {
    public static void main(String[] args) {
        // TreeSet automatically keeps unique elements sorted in natural (ascending) order
        TreeSet<String> names = new TreeSet<>();

        names.add("Rohan");
        names.add("Aakash");
        names.add("Sneha");
        names.add("Divya");
        names.add("Pooja");
        names.add("Aakash"); // Duplicate ignored

        System.out.println("=== Names stored in TreeSet (Alphabetical Order) ===");
        for (String name : names) {
            System.out.println("-> " + name);
        }
    }
}

