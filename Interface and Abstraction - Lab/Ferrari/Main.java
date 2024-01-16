package InterfaceAndAbstraction_04.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String driverName = scanner.nextLine();

        Car Ferrari = new Ferrari(driverName);

        System.out.println(Ferrari.toString());
    }
}
