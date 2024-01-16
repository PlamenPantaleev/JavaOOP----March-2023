package Polymorphism_05.Vehicles_01;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public String drive(double km) {
        StringBuilder sb = new StringBuilder();
        double neededLiters = getLitersPerKm()  * km;
        if (neededLiters <= getFuelQuantity()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            sb.append(String.format("Truck travelled %s km", decimalFormat.format(km)));
            setFuelQuantity(getFuelQuantity() - neededLiters);
        } else {
            sb.append("Truck needs refueling");
        }
        return sb.toString();
    }

    @Override
    public void fillTank(double liters) {
        setFuelQuantity(getFuelQuantity() + (liters * 0.95));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
