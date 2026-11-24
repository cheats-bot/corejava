package hotel.reservations;

import hotel.rooms.Room;
import hotel.customers.Customer;

public class Reservation {
    public boolean bookRoom(Customer customer, Room room) {
        if (!room.isAvailable()) {
            System.out.println("❌ Booking Failed: Room " + room.getRoomId() + " is already reserved!");
            return false;
        }
        room.setAvailable(false);
        System.out.println("✅ Reservation Confirmed: Room " + room.getRoomId() + " (" + room.getType() 
            + ") booked successfully for " + customer.getName() + " (Customer ID: " + customer.getId() + ").");
        return true;
    }

    public boolean cancelRoom(Customer customer, Room room) {
        if (room.isAvailable()) {
            System.out.println("⚠️ Cancellation Warning: Room " + room.getRoomId() + " was not reserved.");
            return false;
        }
        room.setAvailable(true);
        System.out.println("✅ Reservation Cancelled: Room " + room.getRoomId() 
            + " is now available again for booking by " + customer.getName() + ".");
        return true;
    }
}

