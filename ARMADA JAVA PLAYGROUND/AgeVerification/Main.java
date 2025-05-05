package AgeVerification;

import java.util.Scanner;

class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = sc.nextInt();
            if(age < 18){
                throw new AgeRestrictionException("Error: You must be at least 18 to register");
            }
            System.out.println("Registration successful!");
        } catch (AgeRestrictionException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }
}
