package WorkingWithAbstraction_01.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] signals = scanner.nextLine().split("\\s+");

        int iterations = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> lights = new ArrayList<>();

        for (String currentSignal : signals) {
            Color color = Color.valueOf(currentSignal);
            TrafficLight trafficLight = new TrafficLight(color);
            lights.add(trafficLight);
        }
        for (int i = 0; i < iterations; i++) {
            for (TrafficLight light : lights) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
