package rpg_lab;

public interface Target {
    void takeAttack(int attackingPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();

}
