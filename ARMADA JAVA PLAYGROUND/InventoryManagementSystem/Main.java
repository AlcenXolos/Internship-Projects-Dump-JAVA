package InventoryManagementSystem;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> inventory = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Add Product");
                System.out.println("2. Update Product Name");
                System.out.println("3. Find Product by ID");
                System.out.println("4. Remove Product");
                System.out.println("5. Display Inventory");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); 

                int id;
                String name;

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter Product Name: ");
                        name = sc.nextLine();
                        inventory.put(id, name);
                        System.out.println("Product added!");
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        if (inventory.containsKey(id)) {
                            System.out.print("Enter new Product Name: ");
                            name = sc.nextLine();
                            inventory.put(id, name);
                            System.out.println("Product updated!");
                        } else {
                            System.out.println("Product ID not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Product ID: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        if (inventory.containsKey(id)) {
                            System.out.println("Product Found: " + inventory.get(id));
                        } else {
                            System.out.println("Product ID not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to remove: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        if (inventory.containsKey(id)) {
                            inventory.remove(id);
                            System.out.println("Product removed!");
                        } else {
                            System.out.println("Product ID not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Current Inventory:");
                        if (inventory.isEmpty()) {
                            System.out.println("No products in inventory.");
                        } else {
                            for (Map.Entry<Integer, String> entry : inventory.entrySet()) {
                                System.out.println(entry.getKey() + " - " + entry.getValue());
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers where required.");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

