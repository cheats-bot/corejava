/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 1:
 * Create a final class named Constants that contains a public static final variable PI 
 * of type double, initialized to 3.14159. Then, create another class with a main method 
 * to access the PI constant and print its value to the console.
 */

// A final class cannot be extended
final class Constants {
    // Constant variable
    public static final double PI = 3.14159;
}

public class ConstantsDemo {
    public static void main(String[] args) {
        System.out.println("Value of PI constant from Constants class: " + Constants.PI);
        
        double radius = 5.0;
        double circumference = 2 * Constants.PI * radius;
        System.out.printf("Circumference of circle with radius %.1f: %.4f\n", radius, circumference);
    }
}

