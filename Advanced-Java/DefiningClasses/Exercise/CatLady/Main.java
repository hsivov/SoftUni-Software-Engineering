package DefiningClasses.Exercise.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catMap = new HashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] catData = line.split(" ");

            String catBreed = catData[0];
            String catName = catData[1];

            Cat cat = null;

            switch (catBreed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(catName, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(catName, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(catName, decibels);
                    break;
            }
            catMap.put(catName, cat);

            line = scanner.nextLine();
        }
        String nameToSearch = scanner.nextLine();

        System.out.println(catMap.get(nameToSearch));
    }
}
