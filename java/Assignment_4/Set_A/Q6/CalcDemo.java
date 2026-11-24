/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 6:
 * Create a package ‘calc’ with the following classes:
 * a) class Multiplication that has a method multiply(int a, int b) returning their multiplication. 
 * b) class Division that has a method divide(int a, int b) returning their division. 
 * Keep it in the default package with a main class to test the functionality.
 */

import calc.Multiplication;
import calc.Division;

public class CalcDemo {
    public static void main(String[] args) {
        Multiplication mult = new Multiplication();
        Division div = new Division();

        int a = 36, b = 6;
        System.out.println("=== Calc Package Demo (Default Package Main) ===");
        System.out.println("Multiplication (" + a + " * " + b + ") = " + mult.multiply(a, b));
        System.out.println("Division (" + a + " / " + b + ")       = " + div.divide(a, b));
    }
}

