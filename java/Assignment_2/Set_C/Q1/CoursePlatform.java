/*
 * Assignment 2: Constructors & Method Overloading, Inheritance & Method Overriding
 * 
 * SET C - Question 1:
 * Develop a Java application that simulates an online course platform where users can 
 * be either students or instructors. The system should:
 * a) Create a base class User with attributes such as name, email, and userId.
 * b) Demonstrate constructor overloading by providing multiple constructors in the User class (default and parameterized).
 * c) Create two subclasses:
 *    i) Student with additional attributes: courseEnrolled, courseFee
 *    ii) Instructor with additional attributes: courseTeaching, hourlyRate
 * d) Override methods in both subclasses:
 *    i) displayProfile() – to print user details along with role-specific data
 *    ii) getRole() – to return "Student" or "Instructor" respectively
 * e) Use a static variable in the User class to auto-generate unique user IDs.
 * f) In the main() method, create at least one Student and one Instructor object and display their full profiles.
 */

class User {
    protected String userId;
    protected String name;
    protected String email;

    // Static counter for auto-generating unique user IDs
    private static int idCounter = 1000;

    // Default constructor (Demonstrates Constructor Overloading)
    public User() {
        this.userId = "USR" + (++idCounter);
        this.name = "Unknown";
        this.email = "not_provided@example.com";
    }

    // Parameterized constructor (Demonstrates Constructor Overloading)
    public User(String name, String email) {
        this.userId = "USR" + (++idCounter);
        this.name = name;
        this.email = email;
    }

    public String getRole() {
        return "Generic User";
    }

    public void displayProfile() {
        System.out.println("User ID : " + userId);
        System.out.println("Role    : " + getRole());
        System.out.println("Name    : " + name);
        System.out.println("Email   : " + email);
    }
}

class StudentUser extends User {
    private String courseEnrolled;
    private double courseFee;

    public StudentUser(String name, String email, String courseEnrolled, double courseFee) {
        super(name, email);
        this.courseEnrolled = courseEnrolled;
        this.courseFee = courseFee;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Course Enrolled : " + courseEnrolled);
        System.out.printf("Course Fee      : ₹%.2f\n", courseFee);
    }
}

class InstructorUser extends User {
    private String courseTeaching;
    private double hourlyRate;

    public InstructorUser(String name, String email, String courseTeaching, double hourlyRate) {
        super(name, email);
        this.courseTeaching = courseTeaching;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getRole() {
        return "Instructor";
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Course Teaching : " + courseTeaching);
        System.out.printf("Hourly Rate     : ₹%.2f/hr\n", hourlyRate);
    }
}

public class CoursePlatform {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("           ONLINE COURSE PLATFORM USERS           ");
        System.out.println("==================================================");

        // Create Student object
        StudentUser student1 = new StudentUser("Aarav Mehta", "aarav@gmail.com", "Core Java Programming", 4500.0);

        // Create Instructor object
        InstructorUser instructor1 = new InstructorUser("Dr. Priya Sharma", "priya.sharma@college.edu", "Advanced Java & Cloud", 1200.0);

        System.out.println("\n--- Student Profile ---");
        student1.displayProfile();

        System.out.println("\n--- Instructor Profile ---");
        instructor1.displayProfile();
        System.out.println("==================================================");
    }
}

