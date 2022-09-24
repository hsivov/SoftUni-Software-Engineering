package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());

            Map<String, List<String>> countries = continents.get(continent);

            countries.putIfAbsent(country, new ArrayList<>());

            List<String> cities = countries.get(country);

            cities.add(city);
        }
        continents.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((innerKey, innerValue) -> {
                String cities = String.join(", ", innerValue);
                System.out.printf("  %s -> %s%n", innerKey, cities);
            });
        });
    }
}
