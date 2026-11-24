/*
 * Assignment 4: Final Keyword, Garbage Collector, Wrapper Class & Packages
 * 
 * SET C - Question 1:
 * Create packages hotel.rooms, hotel.customers, and hotel.reservations.
 * a) In hotel.rooms, create a Room class with room ID, type, and availability status.
 * b) In hotel.customers, create a Customer class with customer details (id, name)
 * c) In hotel.reservations, create a Reservation class to book and cancel room reservations.
 * Write a main program that simulates room booking and cancellation, checks room 
 * availability, and handles errors such as trying to book an already reserved room.
 */

package app;

import hotel.rooms.Room;
import hotel.customers.Customer;
import hotel.reservations.Reservation;

public class HotelManagementApp {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("           HOTEL RESERVATION SYSTEM               ");
        System.out.println("==================================================");

        // Rooms
        Room r101 = new Room(101, "Deluxe Suite");
        Room r102 = new Room(102, "Standard King");

        // Customers
        Customer c1 = new Customer(1, "Rohan Deshmukh");
        Customer c2 = new Customer(2, "Sneha Patel");

        // Display initial room status
        r101.displayStatus();
        r102.displayStatus();

        // Reservations
        Reservation res = new Reservation();

        System.out.println("\n--- Booking 1: Customer 1 books Room 101 ---");
        res.bookRoom(c1, r101);

        System.out.println("\n--- Booking 2: Customer 2 attempts to book ALREADY RESERVED Room 101 ---");
        res.bookRoom(c2, r101); // Error handled: already reserved

        System.out.println("\n--- Booking 3: Customer 2 books Room 102 ---");
        res.bookRoom(c2, r102);

        System.out.println("\n--- Cancellation: Customer 1 cancels Room 101 ---");
        res.cancelRoom(c1, r101);

        System.out.println("\n--- Booking 4: Customer 2 now successfully books Room 101 ---");
        res.bookRoom(c2, r101);

        System.out.println("\n--- Final Rooms Status ---");
        r101.displayStatus();
        r102.displayStatus();
    }
}

