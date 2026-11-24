/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET B - Question 2:
 * Create a base class Vehicle with attributes: brand, year, price. 
 * Create a subclass Car that inherits from Vehicle and adds specific attributes: numberOfDoors, fuelType.
 * The program should perform following operations:
 * a) Create objects of both Vehicle and Car classes.
 * b) Initialize their attributes using constructor.
 * c) Create a method in each class called displayDetails() to show all the attribute values.
 * d) Use inheritance to reuse attributes and methods from the Vehicle class in the Car class.
 * e) Show the concept of method overriding by redefining displayDetails() in the Car class.
 */

class Vehicle {
    protected String brand;
    protected int year;
    protected double price;

    // Parameterized constructor
    public Vehicle(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Brand : " + brand);
        System.out.println("Year  : " + year);
        System.out.printf("Price : ₹%.2f\n", price);
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;

    // Subclass constructor using super
    public Car(String brand, int year, double price, int numberOfDoors, String fuelType) {
        super(brand, year, price); // Reusing superclass constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // Method overriding of displayDetails()
    @Override
    public void displayDetails() {
        super.displayDetails(); // Reusing superclass method
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type      : " + fuelType);
    }
}

public class VehicleCarDemo {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Object Details ===");
        Vehicle v = new Vehicle("Yamaha", 2022, 120000);
        v.displayDetails();

        System.out.println("\n=== Car Object Details (Overridden Method) ===");
        Car c = new Car("Hyundai Creta", 2024, 1550000, 4, "Diesel");
        c.displayDetails();
    }
}

