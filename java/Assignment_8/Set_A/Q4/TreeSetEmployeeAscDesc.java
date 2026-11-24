/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 4:
 * Write a Java program using TreeSet to store employee names and display them in ascending 
 * and descending order using an Iterator and descendingIterator().
 */

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetEmployeeAscDesc {
    public static void main(String[] args) {
        TreeSet<String> employees = new TreeSet<>();

        employees.add("Ravi");
        employees.add("Aarti");
        employees.add("Suresh");
        employees.add("Kavita");
        employees.add("Bhavna");

        // 1. Ascending order using standard iterator()
        System.out.println("=== Employee Names in ASCENDING Order (iterator()) ===");
        Iterator<String> ascIterator = employees.iterator();
        while (ascIterator.hasNext()) {
            System.out.println("  " + ascIterator.next());
        }

        // 2. Descending order using descendingIterator()
        System.out.println("\n=== Employee Names in DESCENDING Order (descendingIterator()) ===");
        Iterator<String> descIterator = employees.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println("  " + descIterator.next());
        }
    }
}

