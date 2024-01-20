package Solid;

import Solid.calculator.CalorieCalculator;

public class Main {

    public static void main(String[] args) {
        CalorieCalculator calculator = new CalorieCalculator();

        Printer printer = new Printer(calculator);

    }
}
