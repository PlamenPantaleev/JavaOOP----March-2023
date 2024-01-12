package Encaplsulation_02.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s ", name, product.getName()));
        }
        products.add(product);
        money -= product.getCost();
        System.out.printf("%s bought %s%n", name, product.getName());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (products.size() > 0) {
            sb.append(name).append(" - ");
            for (int i = 0; i < products.size(); i++) {
                String productName = products.get(i).getName();
                if (i == products.size() - 1) {
                    sb.append(productName);
                } else {
                    sb.append(productName).append(", ");
                }
            }
            return sb.toString();
        }
        return String.format("%s - Nothing bought!", name);
    }
}
