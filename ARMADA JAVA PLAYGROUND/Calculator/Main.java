package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();
            System.out.println("Result: " + (num1/num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numbers only");
        }
    }
}
