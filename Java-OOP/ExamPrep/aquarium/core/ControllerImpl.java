package ExamPrep.aquarium.core;

import ExamPrep.aquarium.common.ConstantMessages;
import ExamPrep.aquarium.common.ExceptionMessages;
import ExamPrep.aquarium.entities.aquariums.Aquarium;
import ExamPrep.aquarium.entities.aquariums.FreshwaterAquarium;
import ExamPrep.aquarium.entities.aquariums.SaltwaterAquarium;
import ExamPrep.aquarium.entities.decorations.Decoration;
import ExamPrep.aquarium.entities.decorations.Ornament;
import ExamPrep.aquarium.entities.decorations.Plant;
import ExamPrep.aquarium.entities.fish.Fish;
import ExamPrep.aquarium.entities.fish.FreshwaterFish;
import ExamPrep.aquarium.entities.fish.SaltwaterFish;
import ExamPrep.aquarium.repositories.DecorationRepository;
import ExamPrep.aquarium.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{
    private Map<String, Aquarium> aquariums;
    private Repository decorations;

    public ControllerImpl() {
        this.aquariums = new LinkedHashMap<>();
        this.decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        aquariums.put(aquariumName, aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration= new Plant();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium currentAquarium = aquariums.get(aquariumName);

        Decoration currentDeco = decorations.findByType(decorationType);
        if (currentDeco == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        currentAquarium.addDecoration(currentDeco);
        decorations.remove(currentDeco);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;

        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquarium = aquariums.get(aquariumName);
        boolean unsuitable = (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fish.getClass().getSimpleName().equals("SaltwaterFish"))
                || (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fish.getClass().getSimpleName().equals("FreshwaterFish"));

        if (unsuitable) {
            return ConstantMessages.WATER_NOT_SUITABLE;
        }

        try {
            aquarium.addFish(fish);
        } catch (IllegalStateException exception) {
            return exception.toString();
        }
        
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fish.getClass().getSimpleName(), aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);

        aquarium.feed();

        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);

        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decoPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, fishPrice + decoPrice);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        for (Aquarium aquarium : aquariums.values()) {
            sb.append(aquarium.getInfo())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
