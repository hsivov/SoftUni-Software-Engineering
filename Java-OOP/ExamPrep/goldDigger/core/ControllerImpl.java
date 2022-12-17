package ExamPrep.goldDigger.core;

import ExamPrep.goldDigger.common.ConstantMessages;
import ExamPrep.goldDigger.common.ExceptionMessages;
import ExamPrep.goldDigger.models.discoverer.Anthropologist;
import ExamPrep.goldDigger.models.discoverer.Archaeologist;
import ExamPrep.goldDigger.models.discoverer.Discoverer;
import ExamPrep.goldDigger.models.discoverer.Geologist;
import ExamPrep.goldDigger.models.operation.Operation;
import ExamPrep.goldDigger.models.operation.OperationImpl;
import ExamPrep.goldDigger.models.spot.Spot;
import ExamPrep.goldDigger.models.spot.SpotImpl;
import ExamPrep.goldDigger.repositories.DiscovererRepository;
import ExamPrep.goldDigger.repositories.Repository;
import ExamPrep.goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int inspectedSpotsCount;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        discovererRepository.add(discoverer);

        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer searchedDiscoverer = discovererRepository.byName(discovererName);

        if (searchedDiscoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discovererRepository.remove(searchedDiscoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> suitableDiscoverers = discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        Spot spot = spotRepository.byName(spotName);

        operation.startOperation(spot, suitableDiscoverers);
        long count = suitableDiscoverers.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
        inspectedSpotsCount++;

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, count);
    }

    @Override
    public String getStatistics() {

        StringBuilder output = new StringBuilder();

        output.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, inspectedSpotsCount)).append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO);
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            output.append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());

            String discovererExhibits = discoverer.getMuseum().getExhibits().isEmpty()
                    ? "None"
                    : String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits());

            output.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, discovererExhibits));
        }
        return output.toString();
    }
}
