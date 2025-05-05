package MasteringAbstraction;

abstract class Shape {
    abstract void area();
}

class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    void area() {
        System.out.println("Area of Circle: " + Math.PI * (radius*radius) );
    }
}

class Rectangle extends Shape {
    protected double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    void area() {
        System.out.println("Area of Rectangle: " + width*length);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        circle1.area();

        Rectangle rectangle1 = new Rectangle(5, 10);
        rectangle1.area();
    }
}
