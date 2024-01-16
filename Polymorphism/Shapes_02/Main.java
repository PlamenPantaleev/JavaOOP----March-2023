package Polymorphism_05.Shapes_02;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4D);
        Rectangle rectangle = new Rectangle(2D, 4D);

        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
    }
}
