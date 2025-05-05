import java.util.Scanner;

public class GuessingGameABK {
    public static void main(String[] args) {
        int generatedNum = (int)(Math.random() * 50) + 1,
            userGuess = 0, 
            attempts = 0;
        
        Scanner sc = new Scanner(System.in);
        while(userGuess != generatedNum){
            System.out.print("Guess a nuber between 1 and 50: ");
            userGuess = sc.nextInt();

            if(userGuess < generatedNum)
                System.out.println("Too low! Try again.");
            else if(userGuess > generatedNum)
                System.out.println("Too high! Try again.");

            attempts++;
        }

        sc.close();

        System.out.println("Correct! You guessed it in " + attempts + " attempts");
        // System.out.println("num = "+generatedNum);
    }
}
