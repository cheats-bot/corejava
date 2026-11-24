/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET A - Question 3:
 * Write a program using HashMap to store roll numbers (as keys) and student names (as values), 
 * and display the entries using an iterator over entrySet().
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapStudentRoll {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();

        studentMap.put(101, "Neha Patil");
        studentMap.put(102, "Vikram Singhania");
        studentMap.put(103, "Anjali Deshmukh");
        studentMap.put(104, "Karan Malhotra");

        System.out.println("=== Student Roll Directory (using entrySet() Iterator) ===");
        
        // Iterator over entrySet()
        Iterator<Map.Entry<Integer, String>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Roll No: " + entry.getKey() + " => Name: " + entry.getValue());
        }
    }
}

