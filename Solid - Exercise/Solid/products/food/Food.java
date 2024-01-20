package Solid.products.food;

import Solid.products.Product;

public abstract class Food implements Product {
    private double grams;
    private double caloriesPer100GRams;

    public Food(double grams, double caloriesPer100GRams) {
        this.grams = grams;
        this.caloriesPer100GRams = caloriesPer100GRams;
    }

    public double getGrams() {
        return this.grams;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100GRams / 100) * grams;
    }
    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
