/*
 * Assignment 6: File Handling
 * 
 * SET B - Question 4:
 * Write a Java program to create a Student class (roll number, name, marks) that 
 * implements Serializable. Serialize a Student object to a file and then deserialize it 
 * back to display its contents.
 */

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int rollNumber;
    private String name;
    private double marks;

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Marks       : " + marks);
    }
}

public class SerializeStudentDemo {
    public static void main(String[] args) {
        String filename = "student.ser";
        Student originalStudent = new Student(101, "Siddharth Rao", 92.5);

        // 1. Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(originalStudent);
            System.out.println("✅ Student object serialized to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // 2. Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("\n✅ Student object deserialized successfully:");
            deserializedStudent.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}

