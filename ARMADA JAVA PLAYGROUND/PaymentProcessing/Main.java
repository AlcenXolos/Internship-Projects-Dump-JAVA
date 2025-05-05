package PaymentProcessing;

import java.util.Scanner;

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class Paypal implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Paypal payment of $" + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentMethod payment = new CreditCard();
        while(true) {
            System.out.print("Choose payment method (1: Credit Cart, 2: Paypal, 3: Exit) : ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    payment.processPayment(100);
                    break;
                case 2:
                    payment = new Paypal();
                    payment.processPayment(250.50);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default: 
                    System.out.println("Invalid Input");
            }
        }
    }
}
