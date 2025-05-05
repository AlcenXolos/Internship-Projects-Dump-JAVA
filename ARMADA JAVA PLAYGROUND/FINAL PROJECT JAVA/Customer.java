import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer in the system
 * It stores the customer's ID and name, and also provides functionality 
 * to access and modify customer details
 * 
 * All customers are stored in a static list to maintain a collection of 
 * all the customers in the system
 */
public class Customer {
    // Unique identifier for the customer
    private int customerId;

    // Name of the customer
    private String customerName;

    // Static list to store all customers
    private static List<Customer> customers = new ArrayList<>();

    /**
     * Constructor to initialize a new Customer object with an ID and name.
     * The customer is also added to the static list of customers
     */
    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        customers.add(this);  // Adds the current customer to the static list of customers
    }

    /**
     * Returns the customer ID
     */
    public int getId() {
        return this.customerId;
    }

    /**
     * Returns the name of the customer
     */
    public String getName() {
        return this.customerName;
    }

    /**
     * Sets a new name for the customer
     */
    public void setCustomerName(String newName) {
        this.customerName = newName;
    }

    /**
     * Displays the customer's details, including their ID and name.
     */
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId + ", Name: " + customerName);
    }

    /**
     * Static method to get the list of all customers
     */
    public static List<Customer> getCustomers() {
        return customers;
    }
}
