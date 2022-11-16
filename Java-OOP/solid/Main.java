package solid;

import solid.output.Printer;
import solid.products.food.Chocolate;
import solid.products.drink.Coke;
import solid.products.drink.Lemonade;
import solid.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        WeightCalculator weightCalculator = new WeightCalculator();
        Printer printer = new Printer();
        List<Product> productList = new ArrayList<>();

        Product coke = new Coke(330);
        Product chocolate = new Chocolate(250);
        Product lemonade = new Lemonade(500);
        productList.add(coke);
        productList.add(chocolate);
        productList.add(lemonade);

        printer.printSum(calorieCalculator.total(productList));
        printer.printAverage(calorieCalculator.average(productList));

        printer.printSum(weightCalculator.total(productList));
    }
}
