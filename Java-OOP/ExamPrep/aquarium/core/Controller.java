package ExamPrep.aquarium.core;

public interface Controller {

    String addAquarium(String aquariumType, String aquariumName);
    String addDecoration(String type);
    String insertDecoration(String aquariumName, String decorationType);
    String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price);
    String feedFish(String aquariumName);
    String calculateValue(String aquariumName);
    String report();
}
