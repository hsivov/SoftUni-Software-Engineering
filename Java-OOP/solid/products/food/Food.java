package solid.products.food;

import solid.products.Product;

public abstract class Food implements Product {

    private double caloriesPer100Grams;
    private double grams;

    public Food(double caloriesPer100Grams, double grams) {
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return getGrams() / 1000;
    }
}
