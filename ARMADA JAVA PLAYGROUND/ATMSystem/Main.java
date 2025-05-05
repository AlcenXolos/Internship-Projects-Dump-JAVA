package ATMSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] balances = {5123, 5000, 7500, 12000, 3000};

        System.out.println("Available accounts:");
        for (int i = 0; i < balances.length; i++) {
            System.out.println("[" + i + "] Account " + (i + 1));
        }

        System.out.print("Enter account index (0-4): ");
        int index = sc.nextInt();
        if (index < 0 || index >= balances.length) {
            System.out.println("Invalid account index.");
            return;
        }

        System.out.println("Current balance: " + balances[index]);

        System.out.print("Enter transaction type (1-Withdraw, 2-Deposit): ");
        int transactionType = sc.nextInt();
        
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        
        if (transactionType == 1) {
            if (amount > 0 && amount <= balances[index]) {
                balances[index] -= amount;
                System.out.println("Transaction successful! New balance: " + balances[index]);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } else if (transactionType == 2) {
            if (amount > 0) {
                balances[index] += amount;
                System.out.println("Transaction successful! New balance: " + balances[index]);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}
