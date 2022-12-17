package ExamPrep.zoo.core;

import ExamPrep.zoo.common.ConstantMessages;
import ExamPrep.zoo.common.ExceptionMessages;
import ExamPrep.zoo.repositories.FoodRepository;
import ExamPrep.zoo.repositories.FoodRepositoryImpl;
import ExamPrep.zoo.entities.animals.Animal;
import ExamPrep.zoo.entities.animals.AquaticAnimal;
import ExamPrep.zoo.entities.animals.TerrestrialAnimal;
import ExamPrep.zoo.entities.areas.Area;
import ExamPrep.zoo.entities.areas.LandArea;
import ExamPrep.zoo.entities.areas.WaterArea;
import ExamPrep.zoo.entities.foods.Food;
import ExamPrep.zoo.entities.foods.Meat;
import ExamPrep.zoo.entities.foods.Vegetable;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        Area area;
        if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        areas.put(areaName,area);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Food desiredFood = foodRepository.findByType(foodType);

        if (desiredFood == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }
        areas.get(areaName).addFood(desiredFood);
        foodRepository.remove(desiredFood);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {

        Area area = areas.get(areaName);
        Animal animal;
        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        String areaType = area.getClass().getSimpleName();
        String output;

        if (animalType.equals("AquaticAnimal") && areaType.equals("WaterArea")) {
            area.addAnimal(animal);
            output = String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else if (animalType.equals("TerrestrialAnimal") && areaType.equals("LandArea")) {
            area.addAnimal(animal);
            output = String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            output = ConstantMessages.AREA_NOT_SUITABLE;
        }

        return output;
    }

    @Override
    public String feedAnimal(String areaName) {
        areas.get(areaName).feed();

        return String.format(ConstantMessages.ANIMALS_FED, areas.get(areaName).getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        double sumKg = areas.get(areaName).getAnimals().stream()
                .mapToDouble(Animal::getKg)
                .sum();

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sumKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : areas.values()) {
            stringBuilder.append(area.getInfo());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
