package Polymorphism.wildFarm;

public class Zebra extends Mammal{

    protected Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            String message = String.format("%ss are not eating that type of food!", getClass().getSimpleName());
            throw new IllegalArgumentException(message);
        }
        super.setFoodEaten(food.getQuantity());
    }
}
