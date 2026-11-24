/*
 * Assignment 6: File Handling
 * 
 * SET C - Question 3:
 * Write a Java program to demonstrate the use of the transient keyword by serializing 
 * an Employee object where the password field is declared as transient. 
 * Deserialize the object and observe the behavior.
 */

import java.io.*;

class EmployeeAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private int empId;
    private String username;
    
    // transient field: will NOT be serialized by JVM
    private transient String password;

    public EmployeeAccount(int empId, String username, String password) {
        this.empId = empId;
        this.username = username;
        this.password = password;
    }

    public void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Username    : " + username);
        System.out.println("Password    : " + password); // Null after deserialization
    }
}

public class TransientKeywordDemo {
    public static void main(String[] args) {
        String filename = "employee_transient.ser";
        EmployeeAccount emp = new EmployeeAccount(101, "admin_user", "Secret@123");

        System.out.println("=== Before Serialization ===");
        emp.display();

        // 1. Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(emp);
            System.out.println("\nObject serialized to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // 2. Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            EmployeeAccount deserializedEmp = (EmployeeAccount) ois.readObject();
            System.out.println("\n=== After Deserialization ===");
            deserializedEmp.display();

            System.out.println("\nOBSERVATION:");
            System.out.println("The transient field 'password' became null upon deserialization.");
            System.out.println("This proves that fields marked with 'transient' are excluded from serialization for security.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}

