/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET A - Question 1:
 * Design a Java class Student with the following attributes: name, roll number, and 
 * marks in three subjects (each out of 100). Use a constructor to initialize the student details. 
 * Implement methods to: calculate total marks, compute percentage, and determine whether 
 * the student has passed or failed. Also, include a method to display the student's result. 
 * Use a static variable to keep track of the total number of Student objects created. 
 * Based on user input, allow object creation and perform the corresponding operations. 
 * Provide an option for the user to continue or exit the program.
 */

import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double marks1;
    private double marks2;
    private double marks3;
    private double totalMarks;
    private double percentage;

    // Static variable to track total number of Student objects created
    private static int objectCount = 0;

    // Parameterized constructor using 'this' keyword
    public Student(String name, int rollNumber, double m1, double m2, double m3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        objectCount++;
        calculateTotal();
        computePercentage();
    }

    // Method to calculate total marks
    public void calculateTotal() {
        this.totalMarks = marks1 + marks2 + marks3;
    }

    // Method to compute percentage
    public void computePercentage() {
        this.percentage = this.totalMarks / 3.0;
    }

    // Method to determine pass or fail
    public boolean isPassed() {
        return (marks1 >= 40 && marks2 >= 40 && marks3 >= 40 && percentage >= 40.0);
    }

    // Method to display result
    public void displayResult() {
        System.out.println("----------------------------------------------");
        System.out.println("Roll Number       : " + rollNumber);
        System.out.println("Student Name      : " + name);
        System.out.println("Subject 1 Marks   : " + marks1);
        System.out.println("Subject 2 Marks   : " + marks2);
        System.out.println("Subject 3 Marks   : " + marks3);
        System.out.println("Total Marks       : " + totalMarks + " / 300");
        System.out.printf("Percentage        : %.2f%%\n", percentage);
        System.out.println("Status            : " + (isPassed() ? "PASSED" : "FAILED"));
        System.out.println("----------------------------------------------");
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

public class StudentDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\n=== Create New Student ===");
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            System.out.print("Enter Marks in Subject 1 (out of 100): ");
            double m1 = sc.nextDouble();
            System.out.print("Enter Marks in Subject 2 (out of 100): ");
            double m2 = sc.nextDouble();
            System.out.print("Enter Marks in Subject 3 (out of 100): ");
            double m3 = sc.nextDouble();
            sc.nextLine(); // consume newline

            Student s = new Student(name, roll, m1, m2, m3);
            System.out.println("\n--- Student Result ---");
            s.displayResult();

            System.out.println("Total Student objects created so far: " + Student.getObjectCount());

            System.out.print("\nDo you want to add another student? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine(); // consume newline
        } while (choice == 'y' || choice == 'Y');

        System.out.println("Program terminated. Total students created: " + Student.getObjectCount());
        sc.close();
    }
}

