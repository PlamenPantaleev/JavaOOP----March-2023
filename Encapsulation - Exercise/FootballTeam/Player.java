package Encaplsulation_02.FootballTeam;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            String errorMessage = "Endurance should be between 0 and 100.";
            throw new IllegalArgumentException(errorMessage);
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            String errorMessage = "Sprint should be between 0 and 100.";
            throw new IllegalArgumentException(errorMessage);
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            String errorMessage = "Dribble should be between 0 and 100.";
            throw new IllegalArgumentException(errorMessage);
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            String errorMessage = "Passing should be between 0 and 100.";
            throw new IllegalArgumentException(errorMessage);
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            String errorMessage = "Shooting should be between 0 and 100.";
            throw new IllegalArgumentException(errorMessage);
        }
        this.shooting = shooting;
    }
    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }
}
