/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 4:
 * Create a class Employee with a final salary field. Assign value through constructor 
 * and display details of multiple employees.
 */

class Employee {
    private int empId;
    private String name;
    // Final field: must be initialized in constructor and cannot be modified thereafter
    private final double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.printf("ID: %-4d | Name: %-15s | Final Salary: ₹%.2f\n", empId, name, salary);
    }
}

public class EmployeeFinalSalaryDemo {
    public static void main(String[] args) {
        System.out.println("=== Employee Directory with Final Salary ===");
        Employee[] employees = {
            new Employee(101, "Neha Joshi", 55000.0),
            new Employee(102, "Amit Patil", 62000.0),
            new Employee(103, "Rohan Kulkarni", 48000.0)
        };

        for (Employee emp : employees) {
            emp.display();
        }
    }
}

