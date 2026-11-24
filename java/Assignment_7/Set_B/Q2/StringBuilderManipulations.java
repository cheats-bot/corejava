/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET B - Question 2:
 * Write a Java program to create a StringBuilder with "JavaJava".
 * a) Insert "Programming" at index 4
 * b) Delete the first "Java"
 * c) Display the resulting string
 */

public class StringBuilderManipulations {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("JavaJava");
        System.out.println("Initial StringBuilder           : " + sb);

        // a) Insert "Programming" at index 4
        sb.insert(4, "Programming");
        System.out.println("After inserting 'Programming'   : " + sb);

        // b) Delete the first "Java" (indices 0 to 4)
        sb.delete(0, 4);
        System.out.println("After deleting the first 'Java' : " + sb);

        // c) Display resulting string
        System.out.println("Resulting string                : " + sb.toString());
    }
}

