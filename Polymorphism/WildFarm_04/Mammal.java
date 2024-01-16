package Polymorphism_05.WildFarm_04;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        if (getAnimalType().equals("Mouse")) {
            System.out.println("SQUEEEAAAK!");
        } else if (getAnimalType().equals("Zebra")) {
            System.out.println("Zs");
        }
    }

    @Override
    public void eat(Food food) {
        if (getAnimalType().equals("Mouse")) {
            if (food.getClass().getSimpleName().equals("Meat")) {
                throw new IllegalArgumentException("Mice are not eating that type of food!");
            } else {
                setFoodEaten(getFoodEaten() + food.getQuantity());
            }
        } else if (getAnimalType().equals("Zebra")) {
            if (food.getClass().getSimpleName().equals("Meat")) {
                throw new IllegalArgumentException("Zebras are not eating that type of food!");
            } else {
                setFoodEaten(getFoodEaten() + food.getQuantity());
            }
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                decimalFormat.format(animalWeight), livingRegion, foodEaten);
    }
}
