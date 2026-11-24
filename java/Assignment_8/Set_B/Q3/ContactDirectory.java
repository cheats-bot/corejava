/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 3:
 * Write a program to maintain a contact directory with a person’s name and mobile number. 
 * Perform the following:
 * a) Add, remove, and search for contacts.
 * b) Display all contacts sorted by name.
 * Hint: Choose between a Map or List depending on how you want to store and search efficiently.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactDirectory {
    public static void main(String[] args) {
        // TreeMap maintains keys (names) in sorted alphabetical order with O(log N) lookup
        TreeMap<String, String> contacts = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Scanner sc = new Scanner(System.in);
        int choice;

        // Sample initial contacts
        contacts.put("Rahul Sharma", "9876543210");
        contacts.put("Aarti Kulkarni", "9123456780");
        contacts.put("Sameer Verma", "9988776655");

        do {
            System.out.println("\n========== CONTACT DIRECTORY ==========");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Display All Contacts (Sorted by Name)");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Mobile Number: ");
                    String phone = sc.nextLine().trim();
                    contacts.put(name, phone);
                    System.out.println("✅ Contact added/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Name to Remove: ");
                    String remName = sc.nextLine().trim();
                    if (contacts.remove(remName) != null) {
                        System.out.println("✅ Contact '" + remName + "' removed successfully.");
                    } else {
                        System.out.println("❌ Contact not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to Search: ");
                    String sName = sc.nextLine().trim();
                    if (contacts.containsKey(sName)) {
                        System.out.println("🔍 Found: " + sName + " => " + contacts.get(sName));
                    } else {
                        System.out.println("❌ Contact not found in directory.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- All Contacts (Sorted by Name) ---");
                    if (contacts.isEmpty()) {
                        System.out.println("Directory is empty.");
                    } else {
                        for (Map.Entry<String, String> entry : contacts.entrySet()) {
                            System.out.printf("%-20s : %s\n", entry.getKey(), entry.getValue());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Contact Directory.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

