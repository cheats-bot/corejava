/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET B - Question 1:
 * Create a base class Employee with details like name, ID, and basic salary. 
 * Derive a subclass Manager that adds additional allowances. 
 * Override a method to calculate the total salary for each type and display all details.
 * 
 * Additional Allowances:
 * - HRA = 25% of basic salary
 * - DA = 15% of basic salary
 * - Special Allowance = ₹5000
 * - Bonus = Optional bonus amount passed during object creation
 */

class Employee {
    protected String name;
    protected int id;
    protected double basicSalary;

    // Constructor
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Method to calculate total salary
    public double calculateTotalSalary() {
        return basicSalary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.printf("Basic Salary  : ₹%.2f\n", basicSalary);
        System.out.printf("Total Salary  : ₹%.2f\n", calculateTotalSalary());
    }
}

class Manager extends Employee {
    private double bonus;
    private static final double SPECIAL_ALLOWANCE = 5000.0;

    // Constructor using super
    public Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    // Constructor with default zero bonus
    public Manager(String name, int id, double basicSalary) {
        this(name, id, basicSalary, 0.0);
    }

    // Override salary calculation with HRA (25%), DA (15%), Special Allowance (5000), and Bonus
    @Override
    public double calculateTotalSalary() {
        double hra = 0.25 * basicSalary;
        double da = 0.15 * basicSalary;
        return basicSalary + hra + da + SPECIAL_ALLOWANCE + bonus;
    }

    // Override display method
    @Override
    public void displayDetails() {
        double hra = 0.25 * basicSalary;
        double da = 0.15 * basicSalary;

        System.out.println("Manager ID        : " + id);
        System.out.println("Name              : " + name);
        System.out.printf("Basic Salary      : ₹%.2f\n", basicSalary);
        System.out.printf("HRA (25%%)         : ₹%.2f\n", hra);
        System.out.printf("DA (15%%)          : ₹%.2f\n", da);
        System.out.printf("Special Allowance : ₹%.2f\n", SPECIAL_ALLOWANCE);
        System.out.printf("Bonus             : ₹%.2f\n", bonus);
        System.out.printf("Total Gross Salary: ₹%.2f\n", calculateTotalSalary());
    }
}

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        System.out.println("============= REGULAR EMPLOYEE =============");
        Employee emp = new Employee("Rajesh Sharma", 101, 30000.0);
        emp.displayDetails();

        System.out.println("\n============= MANAGER WITH BONUS =============");
        Manager mgr1 = new Manager("Ananya Verma", 201, 60000.0, 10000.0);
        mgr1.displayDetails();

        System.out.println("\n============= MANAGER WITHOUT BONUS ==========");
        Manager mgr2 = new Manager("Suresh Patil", 202, 50000.0);
        mgr2.displayDetails();
    }
}

