package ProgrammingFundamentalsFinalExam;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> plantMap = new LinkedHashMap<>();

        for (int input = 1; input <= n; input++) {
            String[] token = scanner.nextLine().split("<->");

            String plant = token[0];
            double rarity = Double.parseDouble(token[1]);

            if (!plantMap.containsKey(plant)){
                plantMap.put(plant, new ArrayList<>());
                plantMap.get(plant).add(0, rarity);
                plantMap.get(plant).add(1, 0.0);
                plantMap.get(plant).add(2, 0.0);
            } else {
                plantMap.get(plant).set(0, rarity);
            }
        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Exhibition")) {
            String command = commandLine.split(": ")[0];
            String plantInfo = commandLine.split(": ")[1];

            String plant = plantInfo.split(" - ")[0];

            switch (command) {
                case "Rate":
                    if (plantMap.containsKey(plant)) {
                        double currentRating = Double.parseDouble(plantInfo.split(" - ")[1]);
                        double rating = plantMap.get(plant).get(1);
                        double count = plantMap.get(plant).get(2);
                        rating += currentRating;
                        count++;
                        plantMap.get(plant).set(1, rating);
                        plantMap.get(plant).set(2, count);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    double rarity = Double.parseDouble(plantInfo.split(" - ")[1]);
                    if (plantMap.containsKey(plant)) {
                        plantMap.get(plant).set(0, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantMap.containsKey(plant)) {
                        plantMap.get(plant).set(1, 0.0);
                        plantMap.get(plant).set(2, 0.0);
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantMap.entrySet()) {
            double averageRating = 0.0;
            if (entry.getValue().get(1) != 0) {
                averageRating = entry.getValue().get(1) / entry.getValue().get(2);
            }
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), averageRating);
        }

    }
}
