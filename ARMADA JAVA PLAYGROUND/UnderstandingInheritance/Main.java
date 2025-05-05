package UnderstandingInheritance;

class Person {
    private String name;
    private int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade){
        super(name, age);
        this.grade = grade;
    }
    public void displayGrade(){

        if(this.grade > 90){
            System.out.println("Grade: A+");
        } else if(this.grade > 80){
            System.out.println("Grade: A");
        } else if(this.grade > 70){
            System.out.println("Grade: B+");
        } else if(this.grade > 60){
            System.out.println("Grade: B");
        } else if(this.grade > 50){
            System.out.println("Grade: C+");
        } else if(this.grade > 40){
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student newStudent = new Student("Alcen", 21, 90);
        newStudent.displayInfo();
        newStudent.displayGrade();
    }
}
