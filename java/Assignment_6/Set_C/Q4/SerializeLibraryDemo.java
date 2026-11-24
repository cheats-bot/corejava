/*
 * Assignment 6: File Handling
 * 
 * SET C - Question 4:
 * Write a Java program to create a Library class that stores an array of exactly 3 Book 
 * objects and serialize/deserialize the Library object.
 */

import java.io.*;

class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String title;
    private double price;

    public Book(int bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }

    public void display() {
        System.out.printf("  ID: %-4d | Title: %-25s | Price: ₹%.2f\n", bookId, title, price);
    }
}

class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private String libraryName;
    private Book[] books; // Exactly 3 Book objects

    public Library(String libraryName, Book[] books) {
        this.libraryName = libraryName;
        this.books = books;
    }

    public void displayLibrary() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("Books in collection:");
        for (Book b : books) {
            b.display();
        }
    }
}

public class SerializeLibraryDemo {
    public static void main(String[] args) {
        String filename = "library.ser";

        Book[] books = {
            new Book(1, "Data Structures in Java", 550.0),
            new Book(2, "Operating Systems", 620.0),
            new Book(3, "Database Management Systems", 490.0)
        };

        Library lib = new Library("Sir Parashurambhau College Central Library", books);

        System.out.println("=== Before Serialization ===");
        lib.displayLibrary();

        // 1. Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(lib);
            System.out.println("\n✅ Library object serialized to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // 2. Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Library deserializedLib = (Library) ois.readObject();
            System.out.println("\n=== After Deserialization ===");
            deserializedLib.displayLibrary();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}

