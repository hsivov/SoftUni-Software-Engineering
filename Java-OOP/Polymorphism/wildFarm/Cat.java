package Polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{

    private String breed;

    protected Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
       super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String
                .format("%s[%s, %s, %s, %s, %d]",
                        getClass().getSimpleName(),
                        super.getAnimalName(),
                        breed,
                        df.format(super.getAnimalWeight()),
                        super.getLivingRegion(),
                        super.getFoodEaten());
    }
}
