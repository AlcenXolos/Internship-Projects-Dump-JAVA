package PracticalExam;

public class Payment {
    private double amount;
    private String paymentMethod; 
    private String creditCardNumber;

    public Payment(double amount, String paymentMethod, String creditCardNumber) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.creditCardNumber = creditCardNumber;
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " via " + paymentMethod);
        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            System.out.println("Credit Card Used: " + maskCreditCard());
        }
    }

    private String maskCreditCard() {
        if (creditCardNumber.length() >= 4) {
            String lastFour = creditCardNumber.substring(creditCardNumber.length() - 4);
            return "**** **** **** " + lastFour;
        } else {
            return "Invalid Card Number";
        }
    }
}

