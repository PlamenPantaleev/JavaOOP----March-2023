package InterfaceAndAbstraction_04.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();
        while (!"End".equals(command)) {
            String[] data = command.split("\\s+");

            Identifiable identifiable;
            if (data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = data[0];
                String id = data[1];
                identifiable = new Robot(model, id);
            }

            identifiableList.add(identifiable);
            command = scanner.nextLine();
        }

        String fakeIDPostFix = scanner.nextLine();

       identifiableList.stream().map(Identifiable::getId)
               .filter(id -> id.endsWith(fakeIDPostFix))
               .forEach(System.out::println);
    }
}
