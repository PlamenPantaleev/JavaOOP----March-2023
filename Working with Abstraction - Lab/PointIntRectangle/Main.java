package WorkingWithAbstraction_01.PointIntRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());

        for (int pointsCount = 1; pointsCount <= numberOfPoints; pointsCount++) {
            int [] currentPointCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int x = currentPointCoordinates[0];
            int y = currentPointCoordinates[1];

            Point searchedPoint = new Point(x, y);

            System.out.println(rectangle.contains(searchedPoint));
        }
    }
}
