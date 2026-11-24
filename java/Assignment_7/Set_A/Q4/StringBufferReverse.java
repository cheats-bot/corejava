/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET A - Question 4:
 * Write a Java program to create a StringBuffer with text "Hello". 
 * Reverse the string and display the result.
 */

public class StringBufferReverse {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("Hello");
        System.out.println("Original StringBuffer : " + sbf);

        // Reverse string buffer
        sbf.reverse();
        System.out.println("Reversed StringBuffer : " + sbf);
    }
}

