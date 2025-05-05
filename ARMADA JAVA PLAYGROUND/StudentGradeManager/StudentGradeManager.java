package StudentGradeManager;

import java.util.Scanner;

class Student {
    String name;
    double[] grades;

    // Constructor for three subjects
    public Student(String name, double grade1, double grade2, double grade3) {
        this.name = name;
        this.grades = new double[]{grade1, grade2, grade3};
    }

    // Overloaded constructor for four subjects
    public Student(String name, double grade1, double grade2, double grade3, double grade4) {
        this.name = name;
        this.grades = new double[]{grade1, grade2, grade3, grade4};
    }

    // Method to calculate average for three or four subjects
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        // Used string format to round off the double to two decimal places then parses it again into double
        return Double.parseDouble(String.format("%.2f", (sum / grades.length)));
    }

    public String classifyGrade(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 80) {
            return "Good";
        } else if (average >= 70) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print((int) grade + " ");
        }
        double average = calculateAverage();
        System.out.println("\nAverage Grade: " + average);
        System.out.println("Classification: " + classifyGrade(average));
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //a student with three grades
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter three grades: ");
        String grades = scanner.nextLine();
        // use split to separate the grades entered in one-line with spaces
        String[] arrGrades = grades.split(" "); 
        // assign the grades
        double grade1 = Double.parseDouble(arrGrades[0]); 
        double grade2 = Double.parseDouble(arrGrades[1]);
        double grade3 = Double.parseDouble(arrGrades[2]);

        Student student1 = new Student(name, grade1, grade2, grade3);
        student1.displayStudentDetails();

        //a student with four grades 
        System.out.print("\nEnter another student name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter four grades: ");
        String grades2 = scanner.nextLine();
        String[] arrGrades2 = grades2.split(" ");
        double grade2_1 = Double.parseDouble(arrGrades2[0]);
        double grade2_2 = Double.parseDouble(arrGrades2[1]);
        double grade2_3 = Double.parseDouble(arrGrades2[2]);
        double grade2_4 = Double.parseDouble(arrGrades2[3]);

        Student student2 = new Student(name2, grade2_1, grade2_2, grade2_3, grade2_4);
        student2.displayStudentDetails();

        scanner.close();
    }
}
