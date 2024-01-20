package ReflectionAndAnnotations_07.barracksWars.core.commands;

import ReflectionAndAnnotations_07.barracksWars.interfaces.Executable;
import ReflectionAndAnnotations_07.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations_07.barracksWars.interfaces.UnitFactory;

public class CommandInterpreter implements ReflectionAndAnnotations_07.barracksWars.interfaces.CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        switch (commandName) {
            case "retire":
                return new RetireCommand(data, repository, unitFactory);
            case "add":
                return new AddCommand(data, repository, unitFactory);
            case "report":
                return new ReportCommand(data, repository, unitFactory);
            case "fight":
                return new FightCommand(data, repository, unitFactory);
            default:
                throw new RuntimeException("Invalid command!");
        }
    }
}
