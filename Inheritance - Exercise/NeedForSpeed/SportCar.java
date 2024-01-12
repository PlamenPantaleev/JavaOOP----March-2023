package Inheritance_03.NeedForSpeed;

public class SportCar extends Car {
    public final static double SPORTS_CAR_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsepower) {
        super(fuel, horsepower);
        setFuelConsumption(SPORTS_CAR_FUEL_CONSUMPTION);
    }
}
