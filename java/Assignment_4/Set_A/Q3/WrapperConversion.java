/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 3:
 * Write a Java program that declares a primitive int variable, assigns it a value, 
 * and then explicitly converts it into an Integer object using the appropriate wrapper 
 * class method. Finally, print the value of the Integer object to the console.
 */

public class WrapperConversion {
    public static void main(String[] args) {
        // Primitive int variable
        int primitiveNumber = 42;
        System.out.println("Primitive int value: " + primitiveNumber);

        // Explicit conversion using wrapper class method Integer.valueOf()
        Integer wrapperObject = Integer.valueOf(primitiveNumber);

        System.out.println("Integer wrapper object value: " + wrapperObject);
        System.out.println("Class of wrapper object: " + wrapperObject.getClass().getName());
        
        // Demonstrating unboxing
        int unboxed = wrapperObject.intValue();
        System.out.println("Unboxed primitive value: " + unboxed);
    }
}

