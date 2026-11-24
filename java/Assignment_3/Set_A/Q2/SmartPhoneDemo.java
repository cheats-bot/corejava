/*
 * Assignment 3: Abstract Classes & Interfaces
 * 
 * SET A - Question 2 (Lab Book Q3):
 * Design and implement a Java program to simulate a smartphone's features using interfaces. 
 * Define two separate interfaces: Camera, which includes the method takePhoto(), and GPS, 
 * which includes the method trackLocation(). Implement both interfaces in a SmartPhone class 
 * to define the respective functionalities.
 */

// Interface 1: Camera
interface Camera {
    void takePhoto();
}

// Interface 2: GPS
interface GPS {
    void trackLocation();
}

// Class implementing multiple interfaces
class SmartPhone implements Camera, GPS {
    private String modelName;

    public SmartPhone(String modelName) {
        this.modelName = modelName;
    }

    // Implementing method from Camera interface
    @Override
    public void takePhoto() {
        System.out.println("[" + modelName + " Camera]: Captured a high-resolution 48MP photo. Image saved to gallery.");
    }

    // Implementing method from GPS interface
    @Override
    public void trackLocation() {
        System.out.println("[" + modelName + " GPS]: Coordinates locked: 18.5018° N, 73.8536° E (Pune, Maharashtra).");
    }

    public void makeCall(String number) {
        System.out.println("[" + modelName + " Phone]: Calling " + number + "...");
    }
}

public class SmartPhoneDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         SMARTPHONE MULTIPLE INTERFACES DEMO      ");
        System.out.println("==================================================");

        SmartPhone phone = new SmartPhone("Pixel 8 Pro");

        phone.makeCall("+91 9876543210");
        phone.takePhoto();
        phone.trackLocation();
    }
}

