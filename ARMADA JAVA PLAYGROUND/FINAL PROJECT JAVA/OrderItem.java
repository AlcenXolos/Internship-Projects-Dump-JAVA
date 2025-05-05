/**
 * The OrderItem class represents a single item in a customer's order.
 * It contains the product name, quantity ordered, and price per unit.
 */
public class OrderItem {

    private String productName;
    private int quantity;
    private double price;

    /**
     * Constructs an OrderItem with the specified product name, quantity, and price.
     * Throws an IllegalArgumentException if quantity or price is not positive.
     *
     * Accept these parameters:
     * -The name of the product
     * -The quantity of the product ordered (must be > 0)
     *-The price per unit of the product (must be > 0)
     */
    public OrderItem(String productName, int quantity, double price) {
        if (quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("Quantity and price must be positive.");
        }

        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Returns the name of the product.
     *
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Returns the quantity of the product ordered
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns the price per unit of the product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Updates the product name
     */
    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    /**
     * Updates the quantity of the product
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Updates the price of the product
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Displays details of the order item (product name, quantity, price).
     */
    public void displayOrderItemDetails() {
        System.out.println("Product Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: " + price);
    }

    /**
     * Calculates and returns the total price for this item 
     */
    public double calculateTotalPrice() {
        return this.quantity * this.price;
    }
}

