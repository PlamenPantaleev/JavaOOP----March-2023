package ReflectionAndAnnotations_07.barracksWars.core.commands;

import ReflectionAndAnnotations_07.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations_07.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations_07.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command{
    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute()  {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return String.format("%s added!", unitType);
    }
}
