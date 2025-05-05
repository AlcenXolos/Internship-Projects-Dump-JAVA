import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your choice (R, P, S): ");
        String input = sc.nextLine().trim().toUpperCase();
        
        // erforming input validation. It checks if the user input is valid
        // prints invalid choice is the user inputs a series of character, or neither r,p,and s
        if (input.length() != 1 || (input.charAt(0) != 'R' && input.charAt(0) != 'P' && input.charAt(0) != 'S')) {
            System.out.println("Invalid choice. Please enter only 'R', 'P', or 'S'.");
            return;
        }

        char userChoice = input.charAt(0);

        // creates an array of characters for randomied computer choice
        char[] choices = { 'R', 'P', 'S' };
        char computerChoice = choices[random.nextInt(3)];

        System.out.println("Computer chose: " + computerChoice);

        // checking if the user wins using nested switch statement
        switch (userChoice) {
            case 'R':
                switch (computerChoice) {
                    case 'R':
                        System.out.println("It's a tie!");
                        break;
                    case 'P':
                        System.out.println("You lose!");
                        break;
                    case 'S':
                        System.out.println("You win!");
                        break;
                }
                break;

            case 'P':
                switch (computerChoice) {
                    case 'R':
                        System.out.println("You win!");
                        break;
                    case 'P':
                        System.out.println("It's a tie!");
                        break;
                    case 'S':
                        System.out.println("You lose!");
                        break;
                }
                break;

            case 'S':
                switch (computerChoice) {
                    case 'R':
                        System.out.println("You lose!");
                        break;
                    case 'P':
                        System.out.println("You win!");
                        break;
                    case 'S':
                        System.out.println("It's a tie!");
                        break;
                }
                break;
        }

        sc.close();
    }
}
