/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET A - Question 3:
 * Design a Java program that uses a class Student with attributes: 
 * name, roll number, course, marks in three subjects. 
 * The program should:
 * a) Create at least two student objects
 * b) Compute and display total marks and percentage
 * c) Display all the details of the student
 */

import java.util.Scanner;

class Student {
    // Attributes
    String name;
    int rollNumber;
    String course;
    double marks1;
    double marks2;
    double marks3;
    double totalMarks;
    double percentage;

    // Method to accept student details (No constructor used as per Lab Book instructions)
    void acceptDetails(Scanner sc) {
        System.out.print("Enter Student Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        this.rollNumber = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Course Name: ");
        this.course = sc.nextLine();
        System.out.print("Enter Marks for Subject 1: ");
        this.marks1 = sc.nextDouble();
        System.out.print("Enter Marks for Subject 2: ");
        this.marks2 = sc.nextDouble();
        System.out.print("Enter Marks for Subject 3: ");
        this.marks3 = sc.nextDouble();
        sc.nextLine(); // consume newline
    }

    // Method to compute total marks and percentage
    void computeResult() {
        this.totalMarks = marks1 + marks2 + marks3;
        this.percentage = this.totalMarks / 3.0;
    }

    // Method to display all details of the student
    void displayDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : Sub1: " + marks1 + ", Sub2: " + marks2 + ", Sub3: " + marks3);
        System.out.println("Total Marks : " + totalMarks + " / 300");
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Result      : " + (percentage >= 40.0 ? "Passed" : "Failed"));
        System.out.println("----------------------------------------------");
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter details for Student 1 ===");
        Student s1 = new Student();
        s1.acceptDetails(sc);
        s1.computeResult();

        System.out.println("\n=== Enter details for Student 2 ===");
        Student s2 = new Student();
        s2.acceptDetails(sc);
        s2.computeResult();

        System.out.println("\n============== STUDENT DETAILS ==============");
        s1.displayDetails();
        s2.displayDetails();

        sc.close();
    }
}

