package Kapitbahay_Alcen;

import java.io.*;
import java.util.HashMap;

public class UserAuthSystem {

    private static final String FILE_PATH = "C:\\Users\\USER\\OneDrive\\Desktop\\ARMADA JAVA PLAYGROUND\\Kapitbahay_Alcen\\records.txt";

    public static boolean isAlphanumeric(String input) {
        return input != null && input.matches("^[a-zA-Z0-9]+$");
    }

    public static HashMap<String, String> loadUsersFromFile() {
        HashMap<String, String> users = new HashMap<>();
        try (BufferedReader filebr = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = filebr.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public static void main(String[] args) {
        BufferedReader inputbr = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> userMap = loadUsersFromFile();

        System.out.println("Welcome to User Registration");

        while (true) {
            try {
                System.out.println("\n1. Register\n2. Login\n3. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(inputbr.readLine());

                String name, password;

                switch (choice) {
                    case 1:
                        System.out.println("\nRegistration:");

                        do {
                            System.out.print("Please Enter Your Username: ");
                            name = inputbr.readLine().trim();
                            if (!isAlphanumeric(name)) {
                                System.out.println("Username must be alphanumeric! Please try again.");
                            } else if (userMap.containsKey(name)) {
                                System.out.println("Username already exists. Please try a different one.");
                                name = null;
                            }
                        } while (name == null || !isAlphanumeric(name));

                        do {
                            System.out.print("Please Enter Your Password: ");
                            password = inputbr.readLine().trim();
                            if (!isAlphanumeric(password)) {
                                System.out.println("Password must be alphanumeric! Please try again.");
                            }
                        } while (!isAlphanumeric(password));

                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                            bw.write(name + " " + password);
                            bw.newLine();
                            userMap.put(name, password);
                            System.out.println("Registration successful!");
                        } catch (IOException e) {
                            System.out.println("Error writing to file: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Login:");

                        do {
                            System.out.print("Please Enter Your Username: ");
                            name = inputbr.readLine().trim();
                            if (!isAlphanumeric(name)) {
                                System.out.println("Username must be alphanumeric! Please try again.");
                            }
                        } while (!isAlphanumeric(name));

                        do {
                            System.out.print("Please Enter Your Password: ");
                            password = inputbr.readLine().trim();
                            if (!isAlphanumeric(password)) {
                                System.out.println("Password must be alphanumeric! Please try again.");
                            }
                        } while (!isAlphanumeric(password));

                        if (userMap.containsKey(name) && userMap.get(name).equals(password)) {
                            System.out.println("Successfully logged in!");
                            System.exit(0);
                        } else {
                            System.out.println("Incorrect username or password.");
                        }
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }

            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
