package WorkingWithAbstraction_01.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        fillInGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long collectedStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvil(galaxy, evilCoordinates);
            collectedStars = moveJedi(galaxy, jediCoordinates);

            command = scanner.nextLine();
        }

        System.out.println(collectedStars);

    }

    private static long moveJedi(int[][] galaxy, int[] ivoS) {
        int rowJedi = ivoS[0];
        int colJedi = ivoS[1];
        long sum = 0;
        while (rowJedi >= 0 && colJedi < galaxy[1].length) {
            if (isInGalaxy(rowJedi, colJedi, galaxy)) {
                sum += galaxy[rowJedi][colJedi];
            }

            colJedi++;
            rowJedi--;
        }
        return sum;
    }

    private static void moveEvil(int[][] galaxy, int[] evil) {
        int evilRow = evil[0];
        int evilCol = evil[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (isInGalaxy(evilRow, evilCol, galaxy)) {
                galaxy[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
    public static boolean isInGalaxy(int row, int col, int[][] galaxy) {
        return row >= 0 && col >= 0 && row < galaxy.length && col < galaxy[row].length;
    }
    private static void fillInGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                galaxy[i][j] = value++;
            }
        }
    }
}
