package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String store = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopMap.putIfAbsent(store, new LinkedHashMap<>());

            Map<String, Double> productsMap = shopMap.get(store);

            productsMap.put(product, price);

            input = scanner.nextLine();
        }
        shopMap.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((innerKey, innerValue) -> System.out.printf("Product: %s, Price: %.1f%n", innerKey, innerValue));
        });
    }
}
