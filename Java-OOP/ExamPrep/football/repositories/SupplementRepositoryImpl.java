package ExamPrep.football.repositories;

import ExamPrep.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository{

    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }
    @Override
    public void add(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findByType(String type) {
        for (Supplement supplement : supplements) {
            if (supplement.getClass().getSimpleName().equals(type)) {
                return supplement;
            }
        }
        return null;
    }
}
