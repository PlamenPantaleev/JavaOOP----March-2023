
package WorkingWithAbstraction_01.GreedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");


        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        fillMap(bag);
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < items.length; i += 2) {
            String itemName = items[i];
            long itemQuantity = Long.parseLong(items[i + 1]);
            long currentQuantityInBag = bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();

            String typeOfItem = getTypeItem(itemName);

            if (typeOfItem.equals("")) {
                continue;
            } else if (bagCapacity < currentQuantityInBag + itemQuantity) {
                continue;
            }

            switch (typeOfItem) {
                case "Gem":
                    long newGemQuantity = gems + itemQuantity;
                    if (newGemQuantity > gold) {
                        continue;
                    }
                    break;
                case "Cash":
                    long newCashQuantity = cash + itemQuantity;
                    if (newCashQuantity > gems) {
                        continue;
                    }
                    break;
            }

            if (!bag.get(typeOfItem).containsKey(itemName)) {
                bag.get(typeOfItem).put(itemName, 0L);
            }

            bag.get(typeOfItem).put(itemName, bag.get(typeOfItem).get(itemName) + itemQuantity);
            if (typeOfItem.equals("Gold")) {
                gold += itemQuantity;
            } else if (typeOfItem.equals("Gem")) {
                gems += itemQuantity;
            } else if (typeOfItem.equals("Cash")) {
                cash += itemQuantity;
            }
        }
        printResult(bag);
    }


    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> bagDetails : bag.entrySet()) {
            Long sumValues = bagDetails.getValue().values().stream().mapToLong(Long::longValue).sum();
            if (sumValues == 0) {
                continue;
            }
            System.out.println(String.format("<%s> $%s", bagDetails.getKey(), sumValues));

            bagDetails.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(item -> System.out.println("##" + item.getKey() + " - " + item.getValue()));
        }
    }

    private static String getTypeItem(String itemName) {
        String typeOfItem = "";
        if (itemName.length() == 3) {
            typeOfItem = "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            typeOfItem = "Gem";
        } else if (itemName.toLowerCase().equals("gold")) {
            typeOfItem = "Gold";
        }
        return typeOfItem;
    }

    private static void fillMap(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        bag.put("Gold", new LinkedHashMap<>());
        bag.put("Gem", new LinkedHashMap<>());
        bag.put("Cash", new LinkedHashMap<>());
    }
}