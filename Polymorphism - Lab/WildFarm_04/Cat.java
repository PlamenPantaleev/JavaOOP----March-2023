package Polymorphism_05.WildFarm_04;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
            return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                    breed, decimalFormat.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
