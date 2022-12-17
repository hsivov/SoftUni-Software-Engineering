package ExamPrep.spaceStation.models.planets;

import ExamPrep.spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetImpl implements Planet{

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        setName(name);
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
