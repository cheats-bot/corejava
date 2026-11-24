/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET B - Question 3:
 * Create a package ‘shapes’ with classes Square and Triangle. Each class should have 
 * methods to calculate area and perimeter. Write a main program in a separate 
 * package to demonstrate both classes.
 */

package app;

import shapes.Square;
import shapes.Triangle;

public class ShapesDemo {
    public static void main(String[] args) {
        System.out.println("=== Shapes Package Demonstration ===");

        Square square = new Square(6.0);
        System.out.printf("Square (side = 6.0):\n");
        System.out.printf("  Area      : %.2f\n", square.area());
        System.out.printf("  Perimeter : %.2f\n", square.perimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.printf("\nTriangle (sides = 3.0, 4.0, 5.0):\n");
        System.out.printf("  Area      : %.2f\n", triangle.area());
        System.out.printf("  Perimeter : %.2f\n", triangle.perimeter());
    }
}

