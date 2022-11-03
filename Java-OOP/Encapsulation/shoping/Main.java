package Encapsulation.shoping;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] personString = scanner.nextLine().split(";");
        for (String personData : personString) {
            String personName = personData.split("=")[0];
            double personMoney = Double.parseDouble(personData.split("=")[1]);

            try {
                Person person = new Person(personName, personMoney);
                people.put(personName, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String[] productString = scanner.nextLine().split(";");
        for (String productData : productString) {
            String productName = productData.split("=")[0];
            double productCost = Double.parseDouble(productData.split("=")[1]);

            try{
                Product product = new Product(productName, productCost);
                productMap.put(productName, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            try {
                if (people.containsKey(personName)) {
                    people.get(personName).buyProduct(productMap.get(productName));
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }
}
