package Polymorphism_05.Vehicles_01;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION = 0.9;
    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public String drive(double km) {
        StringBuilder sb = new StringBuilder();
        double neededLiters = getLitersPerKm() * km;
        if (neededLiters <= getFuelQuantity()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            sb.append(String.format("Car travelled %s km", decimalFormat.format(km)));
            setFuelQuantity(getFuelQuantity() - neededLiters);
        } else {
            sb.append("Car needs refueling");
        }
        return sb.toString();
    }

    @Override
    public void fillTank(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
