package Polymorphism_05.VehiclesExtension_02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        fillMapForVehicles(scanner, vehicles);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            try {
                String[] commandData = scanner.nextLine().split("\\s+");
                String commandType = commandData[0];
                String vehicleType = commandData[1];

                switch (commandType) {
                    case "Drive":
                        double kilometers = Double.parseDouble(commandData[2]);
                        Vehicle vehicle = vehicles.get(vehicleType);
                        System.out.println(vehicle.drive(commandType, kilometers));
                        break;
                    case "DriveEmpty":
                        Vehicle bus = vehicles.get(vehicleType);
                        System.out.println(bus.drive(commandType, Double.parseDouble(commandData[2])));
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(commandData[2]);
                        Vehicle vehicle1 = vehicles.get(vehicleType);
                        vehicle1.fillTank(liters);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicles.forEach((s, vehicle) -> System.out.printf("%s: %.2f%n", s, vehicle.getFuelQuantity()));
    }


    private static void fillMapForVehicles(Scanner scanner, Map<String, Vehicle> vehicles) {
        for (int i = 1; i <= 3; i++) {
            String[] vehicleData = scanner.nextLine().split("\\s+");
            String vehicleType = vehicleData[0];
            double fuelQuantity = Double.parseDouble(vehicleData[1]);
            double litersPerKm = Double.parseDouble(vehicleData[2]);
            int tankCapacity = Integer.parseInt(vehicleData[3]);

            switch (vehicleType) {
                case "Car":
                    Vehicle car = new Car(fuelQuantity, litersPerKm, tankCapacity);
                    vehicles.put("Car", car);
                    break;
                case "Truck":
                    Vehicle truck = new Truck(fuelQuantity, litersPerKm, tankCapacity);
                    vehicles.put("Truck", truck);
                    break;
                case "Bus":
                    Vehicle bus = new Bus(fuelQuantity, litersPerKm, tankCapacity);
                    vehicles.put("Bus", bus);
                    break;
            }
        }
    }
}
