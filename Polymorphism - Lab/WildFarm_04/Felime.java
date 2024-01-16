package Polymorphism_05.WildFarm_04;

public class Felime extends Mammal{
    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        if (getAnimalType().equals("Tiger")) {
            System.out.println("ROAAR!!!");
        } else {
            System.out.println("Meowwww");
        }
    }

    @Override
    public void eat(Food food) {
        if (getAnimalType().equals("Tiger")) {
            if (food.getClass().getSimpleName().equals("Vegetable")) {
                throw new IllegalArgumentException("Tigers are not eating that type of food!");
            } else {
                setFoodEaten(getFoodEaten() + food.getQuantity());
            }
        } else {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        }
    }
}
