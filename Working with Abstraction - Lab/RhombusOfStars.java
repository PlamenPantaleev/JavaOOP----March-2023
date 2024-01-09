package WorkingWithAbstraction_01;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopPart(n);

        printModdlePart(n);

        printBottomPart(n);
    }

    private static void printBottomPart(int n) {
        for (int row = n -1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printModdlePart(int n) {
        for (int stars = 1; stars <= n; stars++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row < n; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        for (int spaces = 1; spaces <= n - row; spaces++) {
            System.out.print(" ");
        }

        for (int stars = 1; stars <= row; stars++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}
