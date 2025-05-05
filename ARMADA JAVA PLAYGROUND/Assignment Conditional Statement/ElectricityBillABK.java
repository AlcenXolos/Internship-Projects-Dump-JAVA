import java.util.Scanner;

public class ElectricityBillABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of units consumed: ");
        int units = sc.nextInt();
        double bill = 0.0;
        if (units < 0) {
            System.out.println("Invalid input");
            return;
        }

        // different logics for computing total bill 
        if (units <= 100) {
            bill = (100 * 1.50);
            System.out.println("1");
        } else if (units <= 300) {
            bill = (100 * 1.50) + (units - 100) * 2.50;
            System.out.println("2");
        } else {   
            bill = (100 * 1.50) + (200 * 2.50) + (units - 300) * 3.50; 
            System.out.println("3");
        }

        System.out.println("Total Bill: " + bill);
        sc.close();
    }
}
