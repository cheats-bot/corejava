/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET A - Question 1:
 * Write a Java program to create two strings "Hello" and "World" and 
 * concatenate them using both + operator and concat() method. Display the results.
 */

public class StringConcatDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";

        // 1. Concatenation using + operator
        String resultPlus = s1 + " " + s2;

        // 2. Concatenation using concat() method
        String resultConcat = s1.concat(" ").concat(s2);

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Result using '+' operator  : " + resultPlus);
        System.out.println("Result using concat() method: " + resultConcat);
    }
}

