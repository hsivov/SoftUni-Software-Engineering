package ExamPrep.aquarium.entities.aquariums;

import ExamPrep.aquarium.entities.decorations.Decoration;
import ExamPrep.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPrep.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static ExamPrep.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return decorations.stream()
                .mapToInt(Decoration::getComfort)
                .sum();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%s (%s):", name, getClass().getSimpleName())).append(System.lineSeparator());
        if (fish.isEmpty()) {
            output.append("Fish: none").append(System.lineSeparator());
        } else {
            output.append("Fish: ");
            for (Fish fishy : fish) {
                output.append(fishy.getName()).append(" ");
            }
            output.append(System.lineSeparator());
        }
        output.append(String.format("Decorations: %d", decorations.size())).append(System.lineSeparator());
        output.append(String.format("Comfort: %d", calculateComfort()));

        return output.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
