import java.io.*;
import java.util.*;

/**
 * Main class to run the console-based Customer Order Tracker system.
 * Allows customer registration, login, order creation, order cancellation,
 * and order viewing. Tracks and logs customer orders.
 */
public class Main {
    private static final String CREDENTIALS_PATH = "credentials.txt"; // File for storing user credentials
    private static final String ORDER_LOG_PATH = "order_logs.txt";    // File for logging order history
    private static int currentCustomerId = -1;                         // Tracks the currently logged-in user
    private static final HashMap<Integer, String> customerMap = new HashMap<>(); // In-memory store for ID-name mapping
    private static final OrderManager orderManager = new OrderManager();         // Manages all orders

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loadCustomersFromFile(); // Load credentials at startup

        while (true) {
            try {
                if (currentCustomerId == -1) {
                    // Menu for guests (not logged in)
                    System.out.println("\n1. Register");
                    System.out.println("2. Log In");
                    System.out.println("0. Exit");
                    System.out.print("Enter choice: ");
                    int choice = Integer.parseInt(br.readLine());

                    switch (choice) {
                        case 1 -> registerCustomer(br);
                        case 2 -> loginCustomer(br);
                        case 0 -> System.exit(0);
                        default -> System.out.println("Invalid choice.");
                    }
                } else {
                    // Menu for logged-in users
                    System.out.println("\nWelcome, " + customerMap.get(currentCustomerId));
                    System.out.println("1. Add Order");
                    System.out.println("2. Cancel Order");
                    System.out.println("3. View My Orders");
                    System.out.println("4. Log Out");
                    System.out.print("Enter choice: ");
                    int choice = Integer.parseInt(br.readLine());

                    switch (choice) {
                        case 1 -> addOrder(br);
                        case 2 -> cancelOrder(br);
                        case 3 -> viewMyOrders();
                        case 4 -> {
                            currentCustomerId = -1;
                            System.out.println("Logged out.");
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Loads customer credentials from file into memory.
     */
    private static void loadCustomersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                customerMap.put(Integer.parseInt(parts[0]), parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Error reading credentials file.");
        }
    }

    /**
     * Handles customer registration and writes credentials to file.
     */
    private static void registerCustomer(BufferedReader br) throws IOException {
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(br.readLine());
        if (customerMap.containsKey(id)) {
            System.out.println("ID already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = br.readLine();
        customerMap.put(id, name);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENTIALS_PATH, true))) {
            writer.write(id + " " + name + "\n");
        }
        System.out.println("Registration successful.");
    }

    /**
     * Verifies user login credentials.
     */
    private static void loginCustomer(BufferedReader br) throws IOException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(br.readLine());
        System.out.print("Enter Name: ");
        String name = br.readLine();

        if (customerMap.containsKey(id) && customerMap.get(id).equals(name)) {
            currentCustomerId = id;
            System.out.println("Logged in successfully.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    /**
     * Allows the logged-in customer to create a new order.
     */
    private static void addOrder(BufferedReader br) throws IOException {
        Customer customer = new Customer(currentCustomerId, customerMap.get(currentCustomerId));
        List<OrderItem> items = new ArrayList<>();

        while (true) {
            System.out.print("Enter Product Name: ");
            String product = br.readLine();
            System.out.print("Enter Quantity: ");
            int qty = Integer.parseInt(br.readLine());
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(br.readLine());

            if (qty < 0 || price < 0) {
                System.out.println("Quantity and price must be positive.");
                continue;
            }

            items.add(new OrderItem(product, qty, price));

            System.out.print("Add more items? (yes/no): ");
            if (!br.readLine().equalsIgnoreCase("yes"))
                break;
        }

        Order order = new Order(customer, items);
        orderManager.addOrder(order);
        orderManager.processOrder(order);
        saveOrderLog(order);
    }

    /**
     * Allows the user to cancel one of their existing orders.
     */
    private static void cancelOrder(BufferedReader br) throws IOException {
        List<Order> customerOrders = orderManager.getOrdersByCustomer(currentCustomerId);

        if (customerOrders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (int i = 0; i < customerOrders.size(); i++) {
            System.out.println("[" + i + "] " + customerOrders.get(i).getStatus());
            customerOrders.get(i).displayOrderDetails();
        }

        System.out.print("Enter order index to cancel: ");
        int index = Integer.parseInt(br.readLine());

        if (index < 0 || index >= customerOrders.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Order order = customerOrders.get(index);
        order.updateStatus("Cancelled");
        order.processRefund();
        saveOrderLog(order);
    }

    /**
     * Displays all orders associated with the current logged-in customer.
     */
    private static void viewMyOrders() {
        List<Order> customerOrders = orderManager.getOrdersByCustomer(currentCustomerId);

        if (customerOrders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : customerOrders) {
                order.displayOrderDetails();
                System.out.println("Total: " + order.calculateTotalPrice() + "\n");
            }
        }
    }

    /**
     * Appends the order details to the log file.
     */
    private static void saveOrderLog(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_LOG_PATH, true))) {
            writer.write("Customer: " + order.getCustomer().getName() + ", Status: " + order.getStatus() + "\n");
            for (OrderItem item : order.getOrderItems()) {
                writer.write("- " + item.getProductName() + " x" + item.getQuantity() + " @ " + item.getPrice() + "\n");
            }
            writer.write("Total: " + order.calculateTotalPrice() + "\n\n");
        } catch (IOException e) {
            System.out.println("Failed to save order log.");
        }
    }
}
