/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET B - Question 2:
 * Create a class Vehicle with a final method start(). Create a subclass Car and try to 
 * override the start() method. Observe what happens. Write the observation below.
 * 
 * Observation:
 * A method declared with the 'final' keyword cannot be overridden by any subclass.
 * When subclass Car declares 'void start()', the Java compiler produces:
 * "error: start() in Car cannot override start() in Vehicle; overridden method is final"
 */

class Vehicle {
    public final void start() {
        System.out.println("Vehicle is starting with standard ignition...");
    }
}

class Car extends Vehicle {
    // Attempting to override final method causes compile error:
    /*
    @Override
    public void start() { // COMPILE ERROR: start() in Car cannot override start() in Vehicle; overridden method is final
        System.out.println("Car is starting with push button...");
    }
    */

    public void drive() {
        System.out.println("Car is driving smoothly.");
    }
}

public class FinalMethodObservation {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("=== Final Method Observation ===");
        car.start(); // Inherited final method works fine
        car.drive();

        System.out.println("\nOBSERVATION:");
        System.out.println("1. When a method is marked 'final', it is inherited by subclasses but cannot be overridden.");
        System.out.println("2. Attempting to override results in the compile error:");
        System.out.println("   'error: start() in Car cannot override start() in Vehicle; overridden method is final'");
        System.out.println("3. Final methods ensure the base implementation remains intact and cannot be altered.");
    }
}

