package ExamPrep.zoo.entities.animals;

import ExamPrep.zoo.common.ExceptionMessages;

public abstract class BaseAnimal implements Animal{

    private String name;
    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        this.kg = kg;
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_KIND_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    @Override
    public double getKg() {
        return kg;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }
}
