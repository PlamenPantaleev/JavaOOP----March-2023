package Inheritance_03.NeedForSpeed;

public class Car extends Vehicle {
    public final static double CAR_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsepower) {
        super(fuel, horsepower);
        setFuelConsumption(CAR_FUEL_CONSUMPTION);
    }
}
