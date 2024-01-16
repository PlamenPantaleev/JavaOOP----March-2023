package InterfaceAndAbstraction_04.BirthdayCelebrations_03;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> thingsWithBirthday = new ArrayList<>();
        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] data = command.split("\\s+");
            String objectType = data[0];
            switch (objectType) {
                case "Citizen":
                    String personName = data[1];
                    int personAge = Integer.parseInt(data[2]);
                    String personId = data[3];
                    String personBirthDate = data[4];
                    Citizen citizen = new Citizen(personName, personAge, personId, personBirthDate);
                    thingsWithBirthday.add(citizen);
                    break;
                case "Pet":
                    String petName = data[1];
                    String petBirthDate = data[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    thingsWithBirthday.add(pet);
                    break;
                case "Robot":
                    String id = data[1];
                    String model = data[2];
                    break;
            }
            command = scanner.nextLine();
        }
        String year = scanner.nextLine();
        boolean isFound = false;
        for (Birthable birthable : thingsWithBirthday) {
            if (birthable.getBirthDate().endsWith(year)) {
                isFound = true;
                System.out.println(birthable.getBirthDate());
            }
        }
        if (!isFound) {
            System.out.println("<no output>");
        }
    }
}
