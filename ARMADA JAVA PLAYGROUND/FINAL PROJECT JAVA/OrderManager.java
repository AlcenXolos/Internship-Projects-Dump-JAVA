import java.util.ArrayList;
import java.util.List;

/**
 * OrderManager handles customer and order management operations.
 * It allows adding customers, processing orders, updating order status,
 * and retrieving or displaying customer/order information.
 */
public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    /**
     * Adds a new customer to the system.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Adds a new order to the system.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Processes and displays details for a given order.
     */
    public void processOrder(Order order) {
        System.out.println("Processing order for: " + order.getCustomer().getName());
        order.displayOrderDetails();
        System.out.println("Total Price: " + order.calculateTotalPrice());
    }

    /**
     * Updates the status of a specific order.
     */
    public void updateOrderStatus(Order order, String newStatus) {
        order.setStatus(newStatus);
        System.out.println("Order status updated to: " + newStatus);
    }

    /**
     * Displays all customers currently registered in the system.
     */
    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
        }
    }

    /**
     * Displays all orders in the system.
     */
    public void displayAllOrders() {
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    /**
     * Returns a list of orders associated with the given customer ID.
     */
    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId() == customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    /**
     * Returns all orders in the system.
     */
    public List<Order> getOrders() {
        return orders;
    }
}
