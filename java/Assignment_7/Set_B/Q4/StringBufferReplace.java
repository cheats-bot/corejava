/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET B - Question 4:
 * Write a Java program to create a StringBuffer with "I love Python". 
 * Replace "Python" with "Java" and display the updated string.
 */

public class StringBufferReplace {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("I love Python");
        System.out.println("Original StringBuffer : " + sbf);

        // Find index of "Python"
        int startIndex = sbf.indexOf("Python");
        if (startIndex != -1) {
            int endIndex = startIndex + "Python".length();
            sbf.replace(startIndex, endIndex, "Java");
        }

        System.out.println("Updated StringBuffer  : " + sbf);
    }
}

