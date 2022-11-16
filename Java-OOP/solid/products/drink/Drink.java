package solid.products.drink;

import solid.products.Product;

public abstract class Drink implements Product {

    private double caloriesPer100Grams;
    private double density;

    private double milliliters;

    public Drink(double caloriesPer100Grams, double density, double milliliters) {
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getGrams() {
        return getMilliliters() * density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return (getMilliliters() / 1000) * density;
    }
}
