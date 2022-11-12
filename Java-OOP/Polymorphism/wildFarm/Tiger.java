package Polymorphism.wildFarm;

public class Tiger extends Felime{

    protected Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            String message = String.format("%ss are not eating that type of food!", getClass().getSimpleName());
            throw new IllegalArgumentException(message);
        }
        super.setFoodEaten(food.getQuantity());
    }
}
