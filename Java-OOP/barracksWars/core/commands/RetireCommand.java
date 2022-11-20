package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;

public class RetireCommand extends Command{

    @Inject
    Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        try {
            repository.removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    }
}
