package SecureBankingSystem;

import java.util.Scanner;

class BankAccount {
    private String accountNumber, accountHolder;
    private double balance, interestRate = 5;
    private String[] transactionHistory;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(balance);
        addTransactionHistory("Initial Deposit: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if(accountNumber.length() < 10) {
            System.out.println("Invalid account number. It should be at least 10 digits long.");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if(accountHolder.isEmpty()) {
            System.out.println("Invalid account holder name. It cannot be empty.");
            return;
        }
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0) {
            System.out.println("Invalid balance. It cannot be negative.");
            return;
        }
        this.balance = balance;
    } 

    public void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("Invalid deposit amount. It cannot be zero or negative.");
            return;
        }
        balance += amount;
        System.out.println("Deposit Successful. New balance: $" + balance);
        addTransactionHistory("Deposit: $" + amount);
    }

    public void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("Invalid withdrawal amount. It cannot be zero or negative.");
            return;
        }
        if(balance - amount < 0) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal Successful. New balance: $" + balance);
        addTransactionHistory("Withdrawal: $" + amount);
    }

    public void viewTransactionHistory(){
        if(transactionHistory == null) {
            System.out.println("\nNo transactions found.");
            return;
        }
        System.out.println("\n--- Transaction History ---");
        for(String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void addTransactionHistory(String transaction) {
        if(transactionHistory == null) {
            transactionHistory = new String[1];
        } else {
            String[] newHistory = new String[transactionHistory.length + 1];
            System.arraycopy(transactionHistory, 0, newHistory, 0, transactionHistory.length);
            transactionHistory = newHistory;
        }
        System.out.println("Transaction Recorded: " + transaction);
        transactionHistory[transactionHistory.length - 1] = transaction;
    }

    public void applyInterest() {
        double interestAmount = balance * interestRate / 100;
        balance += interestAmount;
        System.out.println("Interest applied. New balance: $" + balance + " (Interest Rate: " + interestRate + "% annual)");
        addTransactionHistory("Interest Applied: " + interestAmount);
    }

    public void viewAccountDetails(){
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate * 100 + "%");
    }


}

public class SecureBanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\nWelcome to the Secure Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Interest");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    if (account != null) {
                        System.out.println("An account already exists!");
                        break;
                    }
                    System.out.print("Enter Account Number (10 digits): ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accHolder = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine(); 

                    try {
                        account = new BankAccount(accNum, accHolder, initialDeposit);
                        System.out.println("Account created successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                    } else {
                        account.viewAccountDetails();
                    }
                    break;

                case 3: 
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depositAmount);
                    break;

                case 4: 
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdrawAmount);
                    break;

                case 5: 
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    account.applyInterest();
                    break;

                case 6:
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    account.viewTransactionHistory();
                    break;

                case 7: 
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
