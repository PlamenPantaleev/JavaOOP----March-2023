package Solid.products.drink;

import Solid.products.Product;

public abstract class Drink implements Product {
    private double milliliters;
    private double caloriesPer100Grams;
    private double density;

    public Drink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getCaloriesPer100Grams() {
        return caloriesPer100Grams;
    }


    public double getDensity() {
        return density;
    }


    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        double grams = getMilliliters() * density;
        return (caloriesPer100Grams / 100) * grams;
    }
    @Override
    public double getKilograms() {
        return getLiters() * density;
    }
    public double getLiters() {
        return milliliters * 1000;
    }
}
