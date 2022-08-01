package ProgrammingFundamentalsFinalExam;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> targets = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if (!targets.containsKey(city)) {
                targets.put(city, new ArrayList<>());
                targets.get(city).add(0, population);
                targets.get(city).add(1, gold);
            } else {
                int currentPopulation = targets.get(city).get(0);
                int currentGold = targets.get(city).get(1);
                targets.get(city).set(0, currentPopulation + population);
                targets.get(city).set(1, currentGold + gold);
            }
            input = scanner.nextLine();
        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
            String action = commandLine.split("=>")[0];
            String town = commandLine.split("=>")[1];

            switch (action) {
                case "Plunder":
                    int killedPeople = Integer.parseInt(commandLine.split("=>")[2]);
                    int stolenGold = Integer.parseInt(commandLine.split("=>")[3]);

                    int currentPeople = targets.get(town).get(0) - killedPeople;
                    int currentGold = targets.get(town).get(1) - stolenGold;

                    targets.get(town).set(0, currentPeople);
                    targets.get(town).set(1, currentGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, stolenGold, killedPeople);

                    if (currentPeople == 0 || currentGold == 0) {
                        targets.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    int gold = Integer.parseInt(commandLine.split("=>")[2]);

                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        targets.get(town).set(1, targets.get(town).get(1) + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, targets.get(town).get(1));
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        if (targets.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targets.size());
            targets.forEach((key, value) ->
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value.get(0), value.get(1)));
        }
    }
}
