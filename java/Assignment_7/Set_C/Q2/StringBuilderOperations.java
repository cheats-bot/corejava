/*
 * Assignment 7: String Manipulation, StringBuffer & StringBuilder
 * 
 * SET C - Question 2:
 * Create a StringBuilder with "HelloJava". Perform the following:
 * a) Insert "World" at index 5
 * b) Delete "Java"
 * c) Replace "Hello" with "Hi"
 * d) Display the final string
 */

public class StringBuilderOperations {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("HelloJava");
        System.out.println("Initial string                      : " + sb);

        // a) Insert "World" at index 5 -> "HelloWorldJava"
        sb.insert(5, "World");
        System.out.println("a) After inserting 'World' at index 5: " + sb);

        // b) Delete "Java"
        int javaIndex = sb.indexOf("Java");
        if (javaIndex != -1) {
            sb.delete(javaIndex, javaIndex + "Java".length());
        }
        System.out.println("b) After deleting 'Java'             : " + sb);

        // c) Replace "Hello" with "Hi"
        int helloIndex = sb.indexOf("Hello");
        if (helloIndex != -1) {
            sb.replace(helloIndex, helloIndex + "Hello".length(), "Hi");
        }
        System.out.println("c) After replacing 'Hello' with 'Hi' : " + sb);

        // d) Display the final string
        System.out.println("d) Final String                      : " + sb.toString());
    }
}

