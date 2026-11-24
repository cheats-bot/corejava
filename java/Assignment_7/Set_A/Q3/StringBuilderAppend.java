/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET A - Question 3:
 * Write a Java program to create a StringBuilder with the text "Data". 
 * Append "Analytics" to it and display the final content.
 */

public class StringBuilderAppend {
    public static void main(String[] args) {
        // Initial StringBuilder
        StringBuilder sb = new StringBuilder("Data");
        System.out.println("Initial content : " + sb);

        // Append " Analytics"
        sb.append(" Analytics");
        System.out.println("Final content   : " + sb);
    }
}

