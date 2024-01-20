package ExceptionAndErrorHandling_08;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split(" ");
        int startingRange = Integer.parseInt(range[0]);
        int endingRange = Integer.parseInt(range[1]);
        boolean isValidNumber = false;
        StringBuilder sb = new StringBuilder();
        System.out.printf("Range: [%d...%d]%n", startingRange, endingRange);
        while (!isValidNumber) {
            String input = scanner.nextLine();
            try {

                System.out.println(checkNumber(input, startingRange, endingRange));
                isValidNumber = true;

            } catch (IllegalArgumentException ignored) {
                System.out.printf("Invalid number: %s%n", input);
            }
        }
    }

    private static String checkNumber(String input, int startingRange, int endingRange) {

        int currentNumber = Integer.parseInt(input);
        if (currentNumber < startingRange || currentNumber > endingRange) {
            throw new InvalidParameterException(String.format("Invalid number: %d", currentNumber));
        } else {
            return String.format("Valid number: %s", input);
        }
    }
}
