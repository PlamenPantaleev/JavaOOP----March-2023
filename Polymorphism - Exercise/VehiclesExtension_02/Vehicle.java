package Polymorphism_05.VehiclesExtension_02;

import java.text.DecimalFormat;

public abstract class Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION_CAR = 0.9;
    private final static double AC_ADDITIONAL_CONSUMPTION_BUS = 1.4;
    public final static double AC_ADDITIONAL_CONSUMPTION_TRUCK = 1.6;
    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public String drive(String command, double km) {
        StringBuilder sb = new StringBuilder();
        double neededLiters;
        String vehicleType = this.getClass().getSimpleName();
        if (command.equals("DriveEmpty")) {
            neededLiters = getLitersPerKm() * km;
        } else {
            if (vehicleType.equals("Car")) {
                neededLiters = (litersPerKm + AC_ADDITIONAL_CONSUMPTION_CAR) * km;
            } else if (vehicleType.equals("Truck")) {
                neededLiters = (litersPerKm + AC_ADDITIONAL_CONSUMPTION_TRUCK) * km;
            } else {
                neededLiters = (litersPerKm + AC_ADDITIONAL_CONSUMPTION_BUS) * km;
            }

        }
        if (neededLiters <= getFuelQuantity()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            sb.append(String.format("%s travelled %s km",vehicleType, decimalFormat.format(km)));
            setFuelQuantity(getFuelQuantity() - neededLiters);
        } else {
            sb.append(String.format("%s needs refueling", vehicleType));
        }
        return sb.toString();
    }

    public void fillTank(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");

        } else if (fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");

        } else {
            this.fuelQuantity += liters;
        }
    }
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
