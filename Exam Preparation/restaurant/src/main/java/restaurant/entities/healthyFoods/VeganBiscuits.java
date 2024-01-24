package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.Food;

public class VeganBiscuits extends Food {
    private final static double INITIAL_VEGAN_BISCUIT_PORTION = 205;
    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGAN_BISCUIT_PORTION, price);
    }
}
