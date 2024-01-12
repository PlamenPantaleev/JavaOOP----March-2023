package Encaplsulation_02.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") ||
        toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            String errorMessage = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getToppingType();
    }

    private double getToppingType() {
        double calories = 0;
        switch (toppingType) {
            case "Meat":
                calories = 1.2;
            break;
            case "Veggies":
                calories = 0.8;
            break;
            case "Cheese":
                calories = 1.1;
            break;
            case "Sauce":
                calories = 0.9;
                break;
            default:
                return 0;
        }
        return calories;
    }
}
