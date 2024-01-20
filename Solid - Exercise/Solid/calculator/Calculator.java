package Solid.calculator;

import Solid_06.products.Product;

import java.util.List;

public interface Calculator {
    double total(List<Product> products);
    double average(List<Product> products);
}
