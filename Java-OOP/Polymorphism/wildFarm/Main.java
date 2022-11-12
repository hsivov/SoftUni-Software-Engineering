package Polymorphism.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();
        int line = 1;

        while (!"End".equals(input)) {
            Animal animal;
            Food food;

            if (line % 2 != 0) {
                animal = getAnimal(input);
                animals.add(animal);
            } else {
                food = getFood(input);
                foods.add(food);
            }

            input = scanner.nextLine();
            line++;
        }

        for (int i = 0; i < animals.size(); i++) {

            animals.get(i).makeSound();

            try {
                animals.get(i).eat(foods.get(i));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

        animals.forEach(System.out::println);
    }

    private static Animal getAnimal(String input) {
        String[] animalData = input.split("\\s+");
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];

        switch (animalType) {
            case "Cat":
                String breed = animalData[4];
                return new Cat(animalName, animalType, animalWeight, livingRegion, breed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, livingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, livingRegion);
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, livingRegion);
            default:
                throw new IllegalArgumentException("Unknown Animal");
        }
    }

    private static Food getFood(String input) {
        String[] foodData = input.split("\\s+");
        String foodType = foodData[0];
        Integer quantity = Integer.parseInt(foodData[1]);

        switch (foodType) {
            case "Meat":
                return new Meat(quantity);
            case "Vegetable":
                return new Vegetable(quantity);
            default:
                throw new IllegalArgumentException("Unknown Food");
        }
    }
}
