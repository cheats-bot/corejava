package hotel.rooms;

public class Room {
    private int roomId;
    private String type;
    private boolean isAvailable;

    public Room(int roomId, String type) {
        this.roomId = roomId;
        this.type = type;
        this.isAvailable = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void displayStatus() {
        System.out.println("Room " + roomId + " (" + type + ") - Status: " + (isAvailable ? "Available" : "Occupied"));
    }
}

