package Encapsulation_02.FootballTEam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Team team = new Team("Black Eagles");
        while (n-- > 0) {
            String [] data =bufferedReader.readLine().split("\\s+");

            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);
            Person person = new Person(firstName, lastName, age, salary);

            team.addPlayer(person);

        }
        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Second team have %d players%n", team.getReserveTeam().size());
    }
}
