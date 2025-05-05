import java.util.Scanner;

public class StudentGradesAnalyzerABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numOfStudents = sc.nextInt();
        int grades[] = new int[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Enter grade for student " + (i+1) + ": ");
            grades[i] = sc.nextInt();
        }

        // calls methods to analyze grades
        // System.out.println("=== Grade Analysis ===  ");
        // System.out.println("Total Grades: " + computeTotalGrades(grades));
        System.out.println("\nHighest Grade: " + findHighestGrade(grades));
        System.out.println("Lowest Grade: " + findLowestGrade(grades));
        System.out.println("Average Grade:" + findAverageGrade(grades));
    }

    public static int computeTotalGrades(int[] grades){
        int total = 0;
        for(int grade : grades){
            total += grade; // adds to total
        }
        return total; 
    }

    // method to calculate the average grade of the students in the array
    public static double findAverageGrade(int[] grades){
        int total = computeTotalGrades(grades); // calls the computeTotalGrades() method
        return (double) total / grades.length; // computes and returns the average grade. 
    }

    // method to get the highest grade entered
    public static int findHighestGrade(int[] grades){
        int highest = grades[0]; //initialize the highest grade with the first elements of array
        for(int grade : grades){
            if(grade > highest){ // check if the current grade in the array is higher than the highest variable
                highest = grade;
            }
        }
        return highest;
    }

    // method to get the lowest grade entered
    public static int findLowestGrade(int[] grades){
        int lowest = grades[0]; // initialize the lowest grade with the value of the first element in array
        for(int grade : grades){
            if(grade < lowest){ // condition to check if the current grade in the array is lower than the lowest grade
                lowest = grade;
            }
        }
        return lowest;
    }
}
