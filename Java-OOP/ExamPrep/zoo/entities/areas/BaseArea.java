package ExamPrep.zoo.entities.areas;

import ExamPrep.zoo.common.ExceptionMessages;
import ExamPrep.zoo.entities.animals.Animal;
import ExamPrep.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area{

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return null;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        String resultAnimals = animals.isEmpty()
                ? "none"
                : animals.stream().map(Animal::getName).collect(Collectors.joining(" "));

        return String.format("%s (%s):", name, getClass().getSimpleName()) + System.lineSeparator() +
                String.format("Animals: %s", resultAnimals) + System.lineSeparator() +
                String.format("Foods: %d", foods.size()) + System.lineSeparator() +
                String.format("Calories: %d", sumCalories());
    }
}
