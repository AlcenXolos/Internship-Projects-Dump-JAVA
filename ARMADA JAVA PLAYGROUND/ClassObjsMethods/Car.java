package ClassObjsMethods;

public class Car {
    String brand;
    int year;

    public void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
    public static void main(String[] args) {
        Car newCar = new Car();
        newCar.brand = "Toyota";
        newCar.year = 2020;
        newCar.displayInfo();
    }
}
