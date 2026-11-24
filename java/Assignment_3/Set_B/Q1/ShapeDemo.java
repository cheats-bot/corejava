/*
 * Assignment 3: Abstract Classes & Interfaces
 * 
 * SET B - Question 1:
 * Create an abstract class Shape with an abstract method double area(). 
 * Derive two classes: Circle (with radius) and Rectangle (with length and breadth). 
 * Implement the area() method in both subclasses.
 * a) Accept dimensions via constructor.
 * b) Calculate and display the area for both shapes.
 */

abstract class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    // Abstract method
    public abstract double area();

    public void displayArea() {
        System.out.printf("Area of %-10s: %.2f sq. units\n", shapeName, area());
    }
}

class Circle extends Shape {
    private double radius;

    // Constructor accepting dimension
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    // Constructor accepting dimensions
    public Rectangle(double length, double breadth) {
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        ABSTRACT SHAPE HIERARCHY DEMO             ");
        System.out.println("==================================================");

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(8.0, 4.5);

        circle.displayArea();
        rectangle.displayArea();
    }
}

