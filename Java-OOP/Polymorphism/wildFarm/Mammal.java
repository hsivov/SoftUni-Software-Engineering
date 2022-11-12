package Polymorphism.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    private String livingRegion;
    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String
                .format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(), super.getAnimalName(), df.format(super.getAnimalWeight()), livingRegion, super.getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
