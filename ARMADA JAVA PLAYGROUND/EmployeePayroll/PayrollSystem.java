package EmployeePayroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Employee {
    String name;
    int employeeID;
    double salary;
    String department;
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee() {
        this.name = "John Doe";
        this.employeeID = 0001;
        this.salary = 50000.00;
        this.department = "Sales";

        employeeList.add(this);
    }
    
    public Employee(String name, int employeeID, double salary, String department) {
        
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
        this.department = department;

        employeeList.add(this);
    }

    public String getEmployeeName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void raiseSalary(double percentage) {
        salary += (salary * percentage) / 100;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("\nNo employee found.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for (Employee employee : employeeList) {
            employee.displayInfo();
            System.out.println("-----------------");
        }
    }
}

public class PayrollSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the Employee Payroll Management System");
        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Calculate Annual Salary");
            System.out.println("4. Give Salary Raise");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = br.readLine();
                    System.out.print("Enter employee ID: ");
                    int id = Integer.parseInt(br.readLine());
                    System.out.print("Enter employee salary: ");
                    double salary = Double.parseDouble(br.readLine());
                    System.out.print("Enter department: ");
                    String department = br.readLine();

                    new Employee(name, id, salary, department);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    Employee.displayAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to calculate salary: ");
                    int idToCalculate = Integer.parseInt(br.readLine());

                    boolean found = false;

                    for (Employee employee : Employee.getEmployeeList()) {
                        if (employee.getEmployeeId() == idToCalculate) {
                            System.out.println("Annual Salary of " + employee.getEmployeeName() + ": $"
                                    + employee.calculateAnnualSalary());
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Employee ID not found!");

                    break;
                case 4:
                    System.out.print("Enter employee ID to raise salary: ");
                    int idToRiaseSalary = Integer.parseInt(br.readLine());

                    boolean foundEmployee = false;

                    for (Employee employee : Employee.getEmployeeList()) {
                        if (employee.getEmployeeId() == idToRiaseSalary) {
                            System.out.print("Enter percentage increase: ");
                            double percentage = Double.parseDouble(br.readLine());
                            employee.raiseSalary(percentage);
                            System.out.println("Salary updates successfully! New Salary: $" + employee.getSalary());
                            foundEmployee = true;
                            break;
                        }
                    }

                    if (!foundEmployee)
                        System.out.println("Employee ID not found!");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }

        }
    }
}
