package PracticalExam;

abstract class Room {
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true; 
    }

    public String getRoomType() {
        return this.roomType;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void bookRoom() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println(this.roomType + " has been booked.");
        } else {
            System.out.println("Room is already booked.");
        }
    }

    public void releaseRoom() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(roomType + " is now available.");
        } else {
            System.out.println(roomType + " is already available.");
        }
    }

    abstract public String getDescription();

}
