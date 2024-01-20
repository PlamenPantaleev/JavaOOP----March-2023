package Solid.calculator;

import Solid_06.products.Product;

import java.util.List;

public class WeightCalculator implements Calculator {

    @Override
    public double total(List<Product> products) {
        double sum = products.stream().mapToDouble(Product::getKilograms).sum();
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return total(products) / products.size();
    }
}
