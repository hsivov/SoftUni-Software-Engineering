package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.races.Race;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;

public class RaceRepository implements Repository<Race> {
    @Override
    public Race getByName(String name) {
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return null;
    }

    @Override
    public void add(Race model) {

    }

    @Override
    public boolean remove(Race model) {
        return false;
    }
}
