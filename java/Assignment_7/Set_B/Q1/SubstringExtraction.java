/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET B - Question 1:
 * Write a Java program to extract the substring from index 3 to 8 of the 
 * string "HelloWorldJava" and display it.
 */

public class SubstringExtraction {
    public static void main(String[] args) {
        String original = "HelloWorldJava";

        // Substring from index 3 to 8 (exclusive of 8, so indices 3, 4, 5, 6, 7)
        String sub = original.substring(3, 8);

        System.out.println("Original String                  : " + original);
        System.out.println("Substring from index 3 to index 8: " + sub);
    }
}

