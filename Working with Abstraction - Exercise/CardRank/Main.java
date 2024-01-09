package WorkingWithAbstraction_01.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String input = scanner.nextLine();
        // System.out.println(input + ": ");
        // for (CardSuits cardSuit : CardSuits.values()) {
        // System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit);
        // }

        //String input = scanner.nextLine();
        //System.out.println(input + ": ");

        //for (CardRank cardRank : CardRank.values()) {
        //  System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank);
        //}

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(scanner.nextLine());
        int cardPower = cardRank.getPower() + cardSuit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, cardPower);
    }
}
