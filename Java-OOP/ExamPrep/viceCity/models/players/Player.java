package ExamPrep.viceCity.models.players;

import ExamPrep.viceCity.models.guns.Gun;
import ExamPrep.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
