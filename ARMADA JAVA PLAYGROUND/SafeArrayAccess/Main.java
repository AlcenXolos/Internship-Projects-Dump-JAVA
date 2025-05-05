package SafeArrayAccess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an index (0-4): ");
        int index = sc.nextInt();

        try {

            System.out.println("Element at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: Invalid index. Please enter a number between 0 and 4.");
        }
    }
}
