import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // accepting user inputs from the terminal
        System.out.print("Enter your weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter your height (m): ");
        double height = sc.nextDouble();

        double bmi = weight / (height * height);
        
        // Round to two decimal places
        bmi = Math.round(bmi * 100.0) / 100.0; 

        // ternary operators for checking the status of the bmi result
        String bmiStatus = (bmi < 18.5) ? "Underweight":
                            (bmi < 25) ? "Normal weight" : 
                            (bmi < 30) ? "Overweight" : 
                            "Obese";

        // Displaying the results
        System.out.println("=== BMI Report ===");
        System.out.println("Your BMI: " + bmi);
        System.out.println("Health Status: " + bmiStatus);

        sc.close();
    }
}