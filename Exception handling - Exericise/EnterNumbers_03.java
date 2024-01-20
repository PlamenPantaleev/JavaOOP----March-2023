package ExceptionAndErrorHandling_08;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EnterNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int start = 1;
        int end = 100;

        List<Integer> numbersList = new ArrayList<>();

        while (true) {
            try {
                start = checkInput(input, start, end);
                numbersList.add(start);
            } catch (InvalidParameterException ignored) {
                System.out.printf("Your number is not in range %d - %d!%n", start, end);
            } catch (IllegalArgumentException ignored) {
                System.out.println("Invalid Number!");
            }
            if (numbersList.size() == 10) {
                break;
            }
            input = scanner.nextLine();
        }

        System.out.println(numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

    }

    private static int checkInput(String input, int start, int end) {
        int number = Integer.parseInt(input);
        if (number <= start || number >= end) {
            throw new InvalidParameterException(String.format("Your number is not in range %d - %d!", start, end));
        } else {
            return number;
        }
    }
}
