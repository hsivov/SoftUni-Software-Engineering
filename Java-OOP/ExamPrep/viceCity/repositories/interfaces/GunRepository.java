package ExamPrep.viceCity.repositories.interfaces;

import ExamPrep.viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {

    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
        models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model.getName()) != null;
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }
}
