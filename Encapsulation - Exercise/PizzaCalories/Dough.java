package Encaplsulation_02.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getFlourTypeModifier() * getBakingTechniqueModifier();
    }

    private double getBakingTechniqueModifier() {
        double caloriesForBakingTechnique = 0;
        switch (bakingTechnique) {
            case "Crispy":
                caloriesForBakingTechnique = 0.9;
                break;
            case "Chewy":
                caloriesForBakingTechnique = 1.1;
                break;
            case "Homemade":
                caloriesForBakingTechnique = 1.0;
                break;
            default:
                caloriesForBakingTechnique = 0;
        }
        return caloriesForBakingTechnique;
    }

    private double getFlourTypeModifier() {
        double caloriesForType = 0;
        switch (flourType) {
            case "White":
                caloriesForType = 1.5;
                break;
            case "Wholegrain":
                caloriesForType = 1.0;
                break;
            default:
                caloriesForType = 0;
        }
        return caloriesForType;
    }
}
