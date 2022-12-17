package ExamPrep.football.repositories;

import ExamPrep.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
