/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET A - Question 2:
 * Create a class AreaCalculator with overloaded methods to calculate:
 * a) Area of a circle
 * b) Area of a rectangle
 * c) Area of a triangle
 * Demonstrate the use of method overloading for the above.
 */

public class AreaCalculator {

    // Overloaded method: Area of circle (pi * r * r)
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Overloaded method: Area of rectangle (length * breadth)
    public double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    // Overloaded method: Area of triangle (0.5 * base * height)
    // Parameter order/type differentiates it
    public double calculateArea(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * base * height;
        }
        return base * height;
    }

    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();

        double circleRadius = 7.0;
        double rectLength = 12.0, rectBreadth = 8.0;
        double triBase = 10.0, triHeight = 6.0;

        System.out.println("========== AREA CALCULATOR (METHOD OVERLOADING) ==========");
        
        // 1. Circle
        double circleArea = calc.calculateArea(circleRadius);
        System.out.printf("Area of Circle (radius = %.2f)            : %.2f sq. units\n", circleRadius, circleArea);

        // 2. Rectangle
        double rectArea = calc.calculateArea(rectLength, rectBreadth);
        System.out.printf("Area of Rectangle (length = %.2f, breadth = %.2f) : %.2f sq. units\n", rectLength, rectBreadth, rectArea);

        // 3. Triangle
        double triArea = calc.calculateArea(triBase, triHeight, true);
        System.out.printf("Area of Triangle (base = %.2f, height = %.2f)    : %.2f sq. units\n", triBase, triHeight, triArea);
    }
}

