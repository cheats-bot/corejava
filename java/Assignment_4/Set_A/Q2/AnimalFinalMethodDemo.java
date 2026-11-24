/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET A - Question 2:
 * Create a class named Animal that contains a public final method called getSound(). 
 * This method should return the string "Generic Animal Sound". In the main method, 
 * instantiate an Animal object and call the getSound() method to print its returned value to the console.
 */

class Animal {
    // Final method cannot be overridden by any subclass
    public final String getSound() {
        return "Generic Animal Sound";
    }
}

public class AnimalFinalMethodDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        String sound = animal.getSound();
        System.out.println("Animal sound returned by final method: " + sound);
    }
}

