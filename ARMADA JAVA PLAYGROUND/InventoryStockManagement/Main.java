package InventoryStockManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stock = { 10, 25, 14, 30, 5, 18, 22, 40, 12, 8 };
        System.out.println("Current stock levels: ");
        printStock(stock);

        System.out.print("\nEnter the product index to update (0-9): ");
        int idxProduct = sc.nextInt();
        System.out.print("Enter the new stock value: ");
        int newVal = sc.nextInt();

        stock[idxProduct] = newVal;

        System.out.println("\nUpdated stock levels:");
        printStock(stock);

        System.out.println("\nHighest Stock: " + getHighestStock(stock));
        System.out.println("Lowest Stock: " + getLowestStock(stock));
    }

    public static int getHighestStock(int[] arr) {
        int max = arr[0];

        for (int element : arr) {
            if(element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int getLowestStock(int[] arr) {
        int min = arr[0];

        for (int element : arr) {
            if(element < min) {
                min = element;
            }
        }
        return min;
    }

    public static void printStock(int[] stock) {
        System.out.print("[");
        for (int i = 0; i < stock.length; i++) {
            System.out.print(stock[i]);
            if (i < stock.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
