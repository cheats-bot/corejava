/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET B - Question 1:
 * Create a final class Bank with a method getRateOfInterest(). 
 * Try extending it in another class SBI and observe what happens. Write the observation below.
 * 
 * Observation:
 * A class declared with the 'final' keyword cannot be inherited or subclassed.
 * When class SBI attempts to do 'class SBI extends Bank', the Java compiler reports:
 * "error: cannot inherit from final Bank"
 */

final class Bank {
    public double getRateOfInterest() {
        return 6.5;
    }
}

// Attempting to extend final class Bank causes a compile-time error:
/*
class SBI extends Bank { // COMPILE ERROR: cannot inherit from final Bank
    @Override
    public double getRateOfInterest() {
        return 7.0;
    }
}
*/

public class FinalClassObservation {
    public static void main(String[] args) {
        Bank b = new Bank();
        System.out.println("=== Final Class Observation ===");
        System.out.println("Bank Rate of Interest: " + b.getRateOfInterest() + "%");
        System.out.println("\nOBSERVATION:");
        System.out.println("1. When a class is declared as 'final', it cannot be extended by any other class.");
        System.out.println("2. Attempting 'class SBI extends Bank' results in the compilation error:");
        System.out.println("   'error: cannot inherit from final Bank'");
        System.out.println("3. This provides immutability and security by preventing inheritance.");
    }
}

