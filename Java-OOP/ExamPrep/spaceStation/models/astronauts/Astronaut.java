package ExamPrep.spaceStation.models.astronauts;

import ExamPrep.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
