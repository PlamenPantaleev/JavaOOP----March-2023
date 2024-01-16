package Polymorphism_05.WildFarm_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            Animal animal = createAnimal(command);
            Food food = createFood(scanner);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);
            command = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(Scanner scanner) {
        String[] foodData = scanner.nextLine().split("\\s+");
        String foodType = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);
        Food food = null;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
        }
        return food;
    }

    private static Animal createAnimal(String command) {
        String[] animalData = command.split("\\s+");
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];

        Animal animal = null;
        if (animalType.equals("Cat")) {
            String catBreed = animalData[4];
            animal = new Cat(animalName, animalType, animalWeight, livingRegion, catBreed);
        } else {
            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    break;
            }
        }
        return animal;
    }
}
