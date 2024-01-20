package ReflectionAndAnnotations_07.barracksWars.core.commands;

import ReflectionAndAnnotations_07.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations_07.barracksWars.interfaces.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
