package WorkingWithAbstraction_01.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] inputArray = input.split("\\s+");
        double pricePerDay = Double.parseDouble(inputArray[0]);
        int numberOfDays = Integer.parseInt(inputArray[1]);
        Season season = Season.valueOf(inputArray[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(inputArray[3].toUpperCase());

        double tripPrice = PriceCalculator.calculateHolidayPrice(pricePerDay, numberOfDays, season, discountType);
        System.out.printf("%.2f", tripPrice);

    }
}
