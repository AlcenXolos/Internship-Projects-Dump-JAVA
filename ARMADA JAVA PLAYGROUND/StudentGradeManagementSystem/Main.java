package StudentGradeManagementSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;
    static ArrayList<Student> myList = new ArrayList<>();

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
        myList.add(this);
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public static void displayAllStudents() {
        if (myList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Students List:");
            for (Student x : myList) {
                System.out.println(x.getName() + " - " + x.getGrade());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Grade");
                System.out.println("4. Remove Student");
                System.out.println("5. Exit");

                System.out.print("\nEnter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                String name;
                double grade;
                boolean found;

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        name = sc.nextLine();
                        System.out.print("Enter grade: ");
                        grade = sc.nextDouble();
                        sc.nextLine(); 
                        new Student(name, grade);
                        System.out.println("Student added!");
                        break;

                    case 2:
                        Student.displayAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter student name: ");
                        name = sc.nextLine();
                        found = false;
                        for (Student x : Student.myList) {
                            if (x.getName().equals(name)) {
                                System.out.print("Enter new grade: ");
                                grade = sc.nextDouble();
                                sc.nextLine(); 
                                x.setGrade(grade);
                                System.out.println("Grade updated!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("No Student Name Found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter student name to remove: ");
                        name = sc.nextLine();
                        found = false;
                        for (int i = 0; i < Student.myList.size(); i++) {
                            if (Student.myList.get(i).getName().equals(name)) {
                                Student.myList.remove(i);
                                System.out.println("Student removed!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("No Student Name Found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Input. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter valid data.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
