import java.util.List;

/**
 * The Order class represents an order placed by a customer
 * It contains a list of order items, the associated customer
 * and the current status of the order.
 * 
 * This class implements the Trackable and Refundable interfaces to
 * support status tracking and refund operations (cancellation of orders)
 */
public class Order implements Trackable, Refundable {

    // The customer who placed the order
    private Customer customer;

    // List of items included in the order
    private List<OrderItem> orderItems;

    // Current status of the order 
    private String status;

    /**
     * Constructs an Order with the specified customer and list of order iten
     * Initializes the status as "Pending".
     *
     * Accepts these as parameters:
     * -The customer placing the order
     * -The list of items in the order
     */
    public Order(Customer customer, List<OrderItem> orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.status = "Pending"; // Default status when an order is created
    }

    /**
     * Returns the customer who placed the order
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Returns the list of items in the order
     */
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    /**
     * Returns the current status of the order
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Updates the list of items in the order
     */
    public void setOrderItems(List<OrderItem> newOrderItems) {
        this.orderItems = newOrderItems;
    }

    /**
     * Updates the status of the order
     */
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    /**
     * Implements the updateStatus method from the Trackable interface.
     * Updates the status and prints a confirmation message
     */
    @Override
    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Order status updated to: " + status);
    }

    /**
     * Implements the processRefund method from the Refundable interface.
     * Processes a refund if the order status is "Cancelled".
     */
    @Override
    public void processRefund() {
        if ("Cancelled".equalsIgnoreCase(status)) {
            System.out.println("Refund processed for the order of customer: " + customer.getName());
        } else {
            System.out.println("Refund not applicable. Current order status: " + status);
        }
    }

    /**
     * Displays the details of the order, including each item and total price.
     */
    public void displayOrderDetails() {
        System.out.println("Order for Customer: " + customer.getName());
        for (OrderItem item : orderItems) {
            System.out.println("- " + item.getProductName() +
                    ", Quantity: " + item.getQuantity() +
                    ", Price per item: " + item.getPrice());
        }
        System.out.println("Order Status: " + status);
    }

    /**
     * Calculates the total price of the order based on all order items.
     */
    public double calculateTotalPrice() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
