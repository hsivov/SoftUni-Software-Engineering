package ExamPrep.spaceStation.models.mission;

import ExamPrep.spaceStation.models.astronauts.Astronaut;
import ExamPrep.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
