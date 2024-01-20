package ReflectionAndAnnotations_07.barracksWars;

import ReflectionAndAnnotations_07.barracksWars.core.commands.CommandInterpreter;
import ReflectionAndAnnotations_07.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations_07.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotations_07.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations_07.barracksWars.core.Engine;
import ReflectionAndAnnotations_07.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations_07.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreter(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
