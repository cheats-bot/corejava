/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 5:
 * Create a package ‘mathutils’ with the following classes:
 * a) class Addition that has a method add(int a, int b) returning their sum.
 * b) class Subtraction that has a method sub(int a, int b) returning their subtraction. 
 * Create a separate package with a main class to test the functionality.
 */

// File: MathApp.java (in separate package 'app', importing 'mathutils.*')
package app;

import mathutils.Addition;
import mathutils.Subtraction;

public class MathApp {
    public static void main(String[] args) {
        Addition adder = new Addition();
        Subtraction subtractor = new Subtraction();

        int x = 25, y = 14;
        System.out.println("=== MathUtils Package Demo ===");
        System.out.println("Numbers: " + x + " and " + y);
        System.out.println("Addition Result      : " + adder.add(x, y));
        System.out.println("Subtraction Result   : " + subtractor.sub(x, y));
    }
}

