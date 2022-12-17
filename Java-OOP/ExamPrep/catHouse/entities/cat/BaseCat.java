package ExamPrep.catHouse.entities.cat;

import static ExamPrep.catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat{

    private String name;
    private String breed;

    private int kilograms;

    private double price;

    protected BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setBreed(String breed) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.breed = breed;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }
}
