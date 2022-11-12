package Polymorphism.wildFarm;

public class Mouse extends Mammal{

    protected Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            String message = "Mice are not eating that type of food!";
            throw new IllegalArgumentException(message);
        }
        super.setFoodEaten(food.getQuantity());
    }
}
