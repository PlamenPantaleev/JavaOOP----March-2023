package Encaplsulation_02.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        String[] peopleData = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");
        try {
            createPersons(persons, peopleData);
            createProducts(products, productsInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            try {
                String[] buyerData = command.split("\\s+");
                String buyerName = buyerData[0];
                String productName = buyerData[1];
                Person person = persons.get(buyerName);
                Product product = products.get(productName);
                person.buyProduct(product);
                command = scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                command = scanner.nextLine();
            }

        }

           persons.values().forEach(System.out::println);
    }

    private static void createProducts(Map<String, Product> productsData, String[] products) {
        for (int i = 0; i < products.length; i++) {
            String[] currentProduct = products[i].split("=");
            String productName = currentProduct[0];
            double cost = Double.parseDouble(currentProduct[1]);
            Product product = new Product(productName, cost);
            productsData.put(productName, product);

        }
    }

    private static void createPersons(Map<String, Person> persons, String[] peopleData) {
        for (int i = 0; i < peopleData.length; i++) {
            String[] currentPersonData = peopleData[i].split("=");
            String personName = currentPersonData[0];
            double money = Double.parseDouble(currentPersonData[1]);
            Person person = new Person(personName, money);
            persons.put(personName, person);
        }
    }
}
