package ReflectionAndAnnotation.barracksWars.core.commands;

import ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotation.barracksWars.annotations.Inject;

public class AddCommand extends Command{

    @Inject
    Repository repository;
    @Inject
    UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
