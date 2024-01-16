package Polymorphism_05.VehiclesExtension_02;


public class Truck extends Vehicle {
    private final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void fillTank(double liters) {
        super.fillTank(liters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
