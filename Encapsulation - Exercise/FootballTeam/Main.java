package Encaplsulation_02.FootballTeam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teamMap = new LinkedHashMap<>();

        String line = scanner.nextLine();


        while (!"END".equals(line)) {
            String[] commandParts = line.split(";");
            String startingCommand = commandParts[0];
            String teamName = commandParts[1];

            try {
                switch (startingCommand) {
                    case "FootballTeam.Team":
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = commandParts[2];
                        int endurance = Integer.parseInt(commandParts[3]);
                        int sprint = Integer.parseInt(commandParts[4]);
                        int dribble = Integer.parseInt(commandParts[5]);
                        int passing = Integer.parseInt(commandParts[6]);
                        int shooting = Integer.parseInt(commandParts[7]);

                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamMap.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = commandParts[2];
                        teamMap.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            double rating = teamMap.get(teamName).getRating();
                            System.out.printf("%s - %d%n",teamName, Math.round(rating));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            line = scanner.nextLine();
        }
    }
}

