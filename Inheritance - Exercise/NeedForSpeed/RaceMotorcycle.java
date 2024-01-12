package Inheritance_03.NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
    public final static double RACE_MOTORCYCLE_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsepower) {
        super(fuel, horsepower);
        setFuelConsumption(RACE_MOTORCYCLE_FUEL_CONSUMPTION);
    }
}
