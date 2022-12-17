package ExamPrep.catHouse.entities.houses;

import ExamPrep.catHouse.common.ConstantMessages;
import ExamPrep.catHouse.entities.cat.Cat;
import ExamPrep.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static ExamPrep.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{

    private String name;

    private int capacity;

    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public int sumSoftness() {
        return toys.stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() == capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:", name, getClass().getSimpleName())).append(System.lineSeparator());

        String catsNames = cats.isEmpty()
                ? "none"
                : cats.stream().map(Cat::getName).collect(Collectors.joining(" "));

        sb.append("Cats: ").append(catsNames).append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %d", toys.size(), sumSoftness()));

        return sb.toString();
    }
}
