/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 2:
 * Write a Java Program to accept a series of website visitor names. 
 * a) Keep track of unique visitors only. 
 * b) Display all visitors in alphabetical order. 
 * c) Allow searching if a visitor has already visited. 
 * Hint: Set can handle uniqueness; TreeSet sorts automatically.
 */

import java.util.Scanner;
import java.util.TreeSet;

public class WebsiteVisitorsTreeSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TreeSet automatically keeps unique visitors and sorts them in alphabetical order
        TreeSet<String> uniqueVisitors = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("=== Website Visitor Tracking System ===");
        System.out.println("Enter visitor names (type 'done' to finish):");

        while (true) {
            System.out.print("Visitor Name: ");
            String name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            if (!name.isEmpty()) {
                boolean isNew = uniqueVisitors.add(name);
                if (isNew) {
                    System.out.println("  -> Logged new visitor: " + name);
                } else {
                    System.out.println("  -> (Duplicate visitor: " + name + " already recorded)");
                }
            }
        }

        // b) Display all unique visitors in alphabetical order
        System.out.println("\n=== All Unique Visitors (Alphabetical Order) ===");
        for (String visitor : uniqueVisitors) {
            System.out.println("• " + visitor);
        }
        System.out.println("Total Unique Visitors: " + uniqueVisitors.size());

        // c) Allow searching if a visitor has already visited
        System.out.print("\nEnter a visitor name to search: ");
        String searchName = sc.nextLine().trim();

        if (uniqueVisitors.contains(searchName)) {
            System.out.println("✅ YES! \"" + searchName + "\" has already visited the website.");
        } else {
            System.out.println("❌ NO! \"" + searchName + "\" has NOT visited the website.");
        }

        sc.close();
    }
}

