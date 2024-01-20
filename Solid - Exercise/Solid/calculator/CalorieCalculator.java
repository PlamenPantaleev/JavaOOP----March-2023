package Solid.calculator;

import Solid_06.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator{

    public CalorieCalculator() {
    }

    @Override
    public double total(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }

        return sum;
    }
    @Override
    public double average(List<Product> products) {
        return total(products) / products.size();
    }

}
