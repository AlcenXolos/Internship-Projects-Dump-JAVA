package PracticalExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        rooms.add(new SingleRoom(100));
        rooms.add(new DoubleRoom(150));
        rooms.add(new Suite(300));
        rooms.add(new SingleRoom(90));
        rooms.add(new Suite(280));

        try {
            while (true) {
                System.out.println("\n=== Hotel Booking System ===");
                System.out.println("1. View Available Rooms");
                System.out.println("2. Make a Reservation");
                System.out.println("3. View All Reservations");
                System.out.println("4. Release a Room");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        viewAvailableRooms(rooms);
                        break;

                    case 2:
                        makeReservation(br, rooms, reservations);
                        break;

                    case 3:
                        viewReservations(reservations);
                        break;

                    case 4:
                        releaseRoom(br, rooms, reservations);
                        break;

                    case 5:
                        System.out.println("Thank you for using the Hotel Booking System!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("Input/Output Error: " + e.getMessage());
        }
    }

    public static void viewAvailableRooms(ArrayList<Room> rooms) {
        System.out.println("\n--- Available Rooms ---");
        boolean anyAvailable = false;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isAvailable()) {
                anyAvailable = true;
                System.out.println((i + 1) + ". " + rooms.get(i).getRoomType() +
                        " - $" + rooms.get(i).getPrice() + " - " + rooms.get(i).getDescription());
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms are available at the moment.");
        }
    }

    public static void makeReservation(BufferedReader br, ArrayList<Room> rooms, ArrayList<Reservation> reservations) {
        try {
            viewAvailableRooms(rooms);

            System.out.print("\nSelect Room Number to Book: ");
            int roomChoice = Integer.parseInt(br.readLine());
            if (roomChoice < 1 || roomChoice > rooms.size()) {
                System.out.println("Invalid room number.");
                return;
            }

            Room selectedRoom = rooms.get(roomChoice - 1);

            if (!selectedRoom.isAvailable()) {
                System.out.println("Sorry, this room is already booked!");
                return;
            }

            System.out.print("\nEnter Customer Name: ");
            String name = br.readLine();
            System.out.print("Enter Customer Email: ");
            String email = br.readLine();
            System.out.print("Enter Membership Status (Gold/Silver/Regular): ");
            String membershipStatus = br.readLine();
            Customer customer = new Customer(name, email, membershipStatus);

            System.out.print("\nEnter Check-In Date (yyyy-mm-dd): ");
            String checkInDate = br.readLine();
            System.out.print("Enter Check-Out Date (yyyy-mm-dd): ");
            String checkOutDate = br.readLine();

            Reservation reservation;
            try {
                reservation = new Reservation(selectedRoom, customer, checkInDate, checkOutDate);
            } catch (InvalidDateException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }

            selectedRoom.bookRoom();
            reservation.applyDiscount();

            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.print("Enter choice: ");
            int paymentChoice = Integer.parseInt(br.readLine());
            String paymentMethod = paymentChoice == 1 ? "Cash" : "Credit Card";
            String creditCardNumber = "";

            if (paymentMethod.equals("Credit Card")) {
                System.out.print("Enter Credit Card Number: ");
                creditCardNumber = br.readLine();
            }

            Payment payment = new Payment(reservation.getTotalPrice(), paymentMethod, creditCardNumber);
            payment.processPayment();

            reservations.add(reservation);

            System.out.println("\n=== Booking Successful ===");
            reservation.displayReservationDetails();

        } catch (IOException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    public static void viewReservations(ArrayList<Reservation> reservations) {
        System.out.println("\n--- All Reservations ---");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation res : reservations) {
                res.displayReservationDetails();
                System.out.println("------------------------");
            }
        }
    }

public static void releaseRoom(BufferedReader br, ArrayList<Room> rooms, ArrayList<Reservation> reservations) {
    try {
        System.out.println("\n--- Booked Rooms ---");
        ArrayList<Integer> bookedRoomIndices = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).isAvailable()) {
                bookedRoomIndices.add(i);
                System.out.println((bookedRoomIndices.size()) + ". " + rooms.get(i).getRoomType() +
                        " - $" + rooms.get(i).getPrice() + " - " + rooms.get(i).getDescription());
            }
        }

        if (bookedRoomIndices.isEmpty()) {
            System.out.println("No rooms are currently booked.");
            return;
        }

        System.out.print("\nEnter Room Number to Release: ");
        int roomChoice = Integer.parseInt(br.readLine());

        if (roomChoice < 1 || roomChoice > bookedRoomIndices.size()) {
            System.out.println("Invalid room number.");
            return;
        }

        int selectedRoomIndex = bookedRoomIndices.get(roomChoice - 1);
        Room selectedRoom = rooms.get(selectedRoomIndex);

        if (selectedRoom.isAvailable()) {
            System.out.println("This room is already available.");
        } else {
            selectedRoom.releaseRoom();

            Reservation toRemove = null;
            for (Reservation res : reservations) {
                if (res.getRoom() == selectedRoom) {
                    toRemove = res;
                    break;
                }
            }

            if (toRemove != null) {
                reservations.remove(toRemove);
            }

            System.out.println("Room released and reservation removed successfully.");
        }
    } catch (IOException e) {
        System.out.println("Input Error: " + e.getMessage());
    }
}


}
