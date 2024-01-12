package Encaplsulation_02.FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isRemoved = players.removeIf(p -> p.getName().equals(playerName));
        if (!isRemoved) {
            String errorMessage = String.format("FootballTeam.Player %s is not in %s team.", playerName, this.name);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double getRating() {
       return players.stream()
               .mapToDouble(Player::overallSkillLevel)
               .average()
               .orElse(0);
    }
}
