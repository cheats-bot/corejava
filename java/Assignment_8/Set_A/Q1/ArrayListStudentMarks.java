/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 1:
 * Write a Java program using ArrayList to store marks of students and calculate 
 * the highest, lowest, and average marks using iterators.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListStudentMarks {
    public static void main(String[] args) {
        ArrayList<Double> marksList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter marks for " + n + " students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " marks: ");
            marksList.add(sc.nextDouble());
        }

        if (marksList.isEmpty()) {
            System.out.println("No marks entered.");
            sc.close();
            return;
        }

        // Calculate highest, lowest, and average using Iterator
        Iterator<Double> it = marksList.iterator();
        double highest = marksList.get(0);
        double lowest = marksList.get(0);
        double sum = 0;

        while (it.hasNext()) {
            double mark = it.next();
            sum += mark;
            if (mark > highest) {
                highest = mark;
            }
            if (mark < lowest) {
                lowest = mark;
            }
        }

        double average = sum / marksList.size();

        System.out.println("\n=== Marks Analysis (via Iterator) ===");
        System.out.println("Total Students : " + marksList.size());
        System.out.printf("Highest Marks  : %.2f\n", highest);
        System.out.printf("Lowest Marks   : %.2f\n", lowest);
        System.out.printf("Average Marks  : %.2f\n", average);

        sc.close();
    }
}

