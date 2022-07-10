package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Map<String, Product> productMap = new LinkedHashMap<>();


        while (!inputLine.equals("buy")) {
            String productName = inputLine.split(" ")[0];
            double price = Double.parseDouble(inputLine.split(" ")[1]);
            int quantity = Integer.parseInt(inputLine.split(" ")[2]);

            Product product = new Product(price, quantity);
            if (!productMap.containsKey(productName)) {
                productMap.put(productName, product);
            } else {
                int newQuantity = productMap.get(productName).getQuantity() + quantity;
                product.setQuantity(newQuantity);
                productMap.put(productName, product);
            }
            inputLine = scanner.nextLine();
        }
        productMap.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value.getPrice() * value.getQuantity()));
    }

    public static class Product {
        private double price;
        private int quantity;

        public Product(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}