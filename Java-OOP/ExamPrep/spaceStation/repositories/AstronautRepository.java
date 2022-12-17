package ExamPrep.spaceStation.repositories;

import ExamPrep.spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut>{

    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return astronauts.values();
    }

    @Override
    public void add(Astronaut model) {
        astronauts.put(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return astronauts.remove(model.getName()) != null;
    }

    @Override
    public Astronaut findByName(String name) {
        return astronauts.get(name);
    }
}
