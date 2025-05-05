package PracticalExam;

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

public class Reservation {
    private Room room;
    private Customer customer;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;

    public Reservation(Room room, Customer customer, String checkInDate, String checkOutDate) throws InvalidDateException {
        if (checkInDate.compareTo(checkOutDate) >= 0) {
            throw new InvalidDateException("Check-in date must be before check-out date.");
        }
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = room.getPrice();
    }

    public void applyDiscount() {
        if (customer.getMembershipStatus().equals("Gold")) {
            totalPrice *= 0.8; 
        } else if (customer.getMembershipStatus().equals("Silver")) {
            totalPrice *= 0.9; 
        }
    }

    public void displayReservationDetails() {
        System.out.println("Reservation Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Room Description: " + room.getDescription());
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
        System.out.println("Total Price: $" + totalPrice);
    }

    public Room getRoom() {
        return this.room;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
}
