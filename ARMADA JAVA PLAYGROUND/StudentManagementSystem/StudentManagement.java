package StudentManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Students {
    private String name;
    private int studId;
    private double grade;

    // I used array list to store students
    private static ArrayList<Students> studentList = new ArrayList<>();

    public Students(String name, int studId, double grade) {
        this.name = name;
        this.studId = studId;
        this.grade = grade;

        studentList.add(this); // adds the new student to the list
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public int getStudId() {
        return studId;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // static method to get the list of students
    public static ArrayList<Students> getStudentList() {
        return studentList;
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studId);
        System.out.println("Grade: " + grade);
    }

    // static method to display all students
    public static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Students student : studentList) {
            student.displayStudentDetails();
            System.out.println("-----------------");
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) throws IOException {
        // used buffered rader to acccept user inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the Student Management System");

        // infinite loop until user chooses to exit
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(br.readLine().trim());

            // switch case statements to handle user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = br.readLine().trim();

                    System.out.print("Enter student ID: ");
                    int studId = Integer.parseInt(br.readLine().trim());

                    System.out.print("Enter student grade: ");
                    double grade = Double.parseDouble(br.readLine().trim());

                    new Students(name, studId, grade); // creates a new Student object 
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    Students.displayAllStudents(); // calls displayAllStudent method of the Class
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = Integer.parseInt(br.readLine().trim());

                    System.out.print("Enter new grade: ");
                    double newGrade = Double.parseDouble(br.readLine().trim());

                    boolean found = false;
                    // iterate through the list of students to find the student with the given ID
                    for (Students student : Students.getStudentList()) {
                        if (student.getStudId() == idToUpdate) {
                            student.setGrade(newGrade);
                            System.out.println("Grade updated successfully for student ID: " + idToUpdate);
                            found = true;
                            break;
                        }
                    }

                    // if the student was not found, print an error message
                    if (!found) {
                        System.out.println("Error: Student with ID " + idToUpdate + " not found.");
                    }
                    break;

                case 4:
                // exit the program
                    System.out.println("Paalam kaibigan");
                    br.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        // Students student1 = new Students("Alcen", 1902307, 97.88);
        // Students student2 = new Students("Alcen1", 1902307123, 97.88);
        // Students student3 = new Students("Alcen2", 1902307456, 97.88);
        // student1.displayStudentDetails();
        // Students.displayAllStudents();
    }
}


