import java.util.Scanner;

public class GradingSystemABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int score = sc.nextInt();

        if(score < 0 || score > 100) {
            System.out.println("Invalid score");
            return;
        }
        
        // consitional statements to check for grades
        if (score >= 90) {
            System.out.println("Grade: A\nFeedback: Excellent");
        } else if (score >= 75) {
            System.out.println("Grade: B\nFeedback: Good Job");
        } else if (score >= 50) {
            System.out.println("Grade: C\nFeedback: Keep Up");
        } else {
            System.out.println("Grade: F\nFeedback: Failing");
        }
        sc.close();
    }
}