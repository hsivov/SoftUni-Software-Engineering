package ExamPrep.spaceStation.core;

import ExamPrep.spaceStation.common.ConstantMessages;
import ExamPrep.spaceStation.common.ExceptionMessages;
import ExamPrep.spaceStation.models.astronauts.Astronaut;
import ExamPrep.spaceStation.models.astronauts.Biologist;
import ExamPrep.spaceStation.models.astronauts.Geodesist;
import ExamPrep.spaceStation.models.astronauts.Meteorologist;
import ExamPrep.spaceStation.models.mission.Mission;
import ExamPrep.spaceStation.models.mission.MissionImpl;
import ExamPrep.spaceStation.models.planets.Planet;
import ExamPrep.spaceStation.models.planets.PlanetImpl;
import ExamPrep.spaceStation.repositories.AstronautRepository;
import ExamPrep.spaceStation.repositories.PlanetRepository;
import ExamPrep.spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;

    private int countExploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();

        Planet planet = planetRepository.findByName(planetName);

        List<Astronaut> suitableAstronauts = astronautRepository.getModels().stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());

        if (suitableAstronauts.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planet, suitableAstronauts);
        long countLostAstronauts = suitableAstronauts.stream().filter(astronaut -> astronaut.getOxygen() == 0).count();
        countExploredPlanets++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, countLostAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, countExploredPlanets)).append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO);

        for (Astronaut astronaut : astronautRepository.getModels()) {
            sb.append(System.lineSeparator())
                    .append(astronaut);
        }
        return sb.toString();
    }
}
