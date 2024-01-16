package InterfaceAndAbstraction_04.FoodShortage_04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyers = new LinkedHashMap<>();

        int countOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countOfPeople; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);
            Buyer buyer;
            if (personData.length == 4) {
                //citizen
                String id = personData[2];
                String birthDate = personData[3];
                buyer = new Citizen(personName, personAge, id, birthDate);
            } else {
                //rebel
                String rebelGroup = personData[2];
                buyer = new Rebel(personName, personAge, rebelGroup);
            }
            buyers.put(personName, buyer);
        }

        String nameInput = scanner.nextLine();

        while (!"End".equals(nameInput)) {
            Buyer buyer = buyers.get(nameInput);
            if (buyer != null) {
                buyer.buyFood();
            }


            nameInput = scanner.nextLine();
        }
        int totalFood = buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(totalFood);
    }
}
