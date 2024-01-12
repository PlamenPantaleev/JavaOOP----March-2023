package Inheritance_03.NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(80, 100);
        car.drive(200);
        SportCar sportCar = new SportCar(80, 200);
        sportCar.drive(200);
        sportCar.drive(1000);
    }
}
