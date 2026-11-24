/*
 * Assignment 3: Abstract Classes & Interfaces
 * 
 * SET A - Question 1:
 * Create an abstract class LibraryItem with attributes such as title, author, itemId, 
 * and isAvailable. Include abstract methods like displayInfo() and checkout(). 
 * Derive concrete subclasses Book (with an additional attribute numPages) and Journal 
 * (with an attribute issueNumber), each implementing their own specific behaviors and properties.
 */

abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String itemId;
    protected boolean isAvailable;

    public LibraryItem(String title, String author, String itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
        this.isAvailable = true; // default available
    }

    // Abstract methods to be implemented by subclasses
    public abstract void displayInfo();
    public abstract void checkout();

    public void returnItem() {
        this.isAvailable = true;
        System.out.println("'" + title + "' (ID: " + itemId + ") has been returned and is now available.");
    }
}

class Book extends LibraryItem {
    private int numPages;

    public Book(String title, String author, String itemId, int numPages) {
        super(title, author, itemId);
        this.numPages = numPages;
    }

    @Override
    public void displayInfo() {
        System.out.println("[BOOK DETAILS]");
        System.out.println("  ID        : " + itemId);
        System.out.println("  Title     : " + title);
        System.out.println("  Author    : " + author);
        System.out.println("  Pages     : " + numPages);
        System.out.println("  Available : " + (isAvailable ? "Yes" : "No (Checked out)"));
    }

    @Override
    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Successfully checked out Book: '" + title + "'. Enjoy reading all " + numPages + " pages!");
        } else {
            System.out.println("Sorry, Book '" + title + "' is currently checked out.");
        }
    }
}

class Journal extends LibraryItem {
    private int issueNumber;

    public Journal(String title, String author, String itemId, int issueNumber) {
        super(title, author, itemId);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("[JOURNAL DETAILS]");
        System.out.println("  ID        : " + itemId);
        System.out.println("  Title     : " + title);
        System.out.println("  Editor    : " + author);
        System.out.println("  Issue No. : " + issueNumber);
        System.out.println("  Available : " + (isAvailable ? "Yes" : "No (Checked out)"));
    }

    @Override
    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Successfully checked out Academic Journal: '" + title + "' Issue #" + issueNumber + ".");
        } else {
            System.out.println("Sorry, Journal '" + title + "' Issue #" + issueNumber + " is currently unavailable.");
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("           LIBRARY MANAGEMENT SYSTEM              ");
        System.out.println("==================================================");

        LibraryItem book = new Book("Effective Java", "Joshua Bloch", "B-101", 412);
        LibraryItem journal = new Journal("IEEE Software Engineering", "Dr. A. Smith", "J-504", 42);

        book.displayInfo();
        System.out.println();
        journal.displayInfo();

        System.out.println("\n--- Performing Checkout Operations ---");
        book.checkout();
        book.checkout(); // Attempting duplicate checkout

        System.out.println("\n--- Returning Item ---");
        book.returnItem();
        book.checkout();
    }
}

