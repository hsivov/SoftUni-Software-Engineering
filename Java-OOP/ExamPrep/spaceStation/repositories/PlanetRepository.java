package ExamPrep.spaceStation.repositories;

import ExamPrep.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {

    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return planets.values();
    }

    @Override
    public void add(Planet model) {
        planets.put(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        return planets.remove(model.getName()) != null;
    }

    @Override
    public Planet findByName(String name) {
        return planets.get(name);
    }
}
