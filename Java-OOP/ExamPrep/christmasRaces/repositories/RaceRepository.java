package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.races.Race;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {

    Map<String, Race> races;

    public RaceRepository() {
        this.races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return List.copyOf(new ArrayList<>(races.values()));
    }

    @Override
    public void add(Race race) {
        races.put(race.getName(), race);
    }

    @Override
    public boolean remove(Race race) {
        return races.remove(race.getName()) != null;
    }
}
