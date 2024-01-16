package Polymorphism_05.Vehicles_01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandType = command[0];
            String vehicleType = command[1];

            if (commandType.equals("Drive")) {
                double kilometers = Double.parseDouble(command[2]);
                System.out.println(vehicleMap.get(vehicleType).drive(kilometers));
            } else if (commandType.equals("Refuel")) {
                double liters = Double.parseDouble(command[2]);
                vehicleMap.get(vehicleType).fillTank(liters);
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
