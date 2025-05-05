import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numOfStudents = sc.nextInt();
        System.out.print("Enter the number of subjects:");
        int numOfSubjs = sc.nextInt();
        sc.nextLine();
        int grades[][] = new int[numOfStudents][numOfSubjs];
        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Enter scores for Student " + (i + 1) + ": ");
            String grade = sc.nextLine();

            String[] arrGrade = grade.split(" ");

            for (int j = 0; j < numOfSubjs; j++) {
                grades[i][j] = Integer.parseInt(arrGrade[j]);
            }
        }

        for (int i = 0; i < numOfStudents; i++) {
            int totalGrade = 0;
            double average = 0;
            for (int j = 0; j < numOfSubjs; j++) {
                totalGrade += grades[i][j];
            }
            average =(double) totalGrade / numOfSubjs;
            System.out.println("Student " + (i + 1) + " - Total: " + totalGrade + ", Average: " + average);
        }
    }
}
