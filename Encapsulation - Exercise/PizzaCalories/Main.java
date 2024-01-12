package Encaplsulation_02.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaDataInput = scanner.nextLine().split("\\s+");
        String[] doughDataInput = scanner.nextLine().split("\\s+");
        try {
            Pizza pizza = new Pizza(pizzaDataInput[1], Integer.parseInt(pizzaDataInput[2]));
            Dough dough = new Dough(doughDataInput[1], doughDataInput[2], Double.parseDouble(doughDataInput[3]));
            pizza.setDough(dough);

            String command = scanner.nextLine();
            while (!"END".equals(command)) {
                String[] toppingData = command.split("\\s+");
                String toppingType = toppingData[1];
                double toppingWeightInGrams = Double.parseDouble(toppingData[2]);
                try {
                    Topping topping = new Topping(toppingType, toppingWeightInGrams);
                    pizza.addTopping(topping);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }

                command = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
