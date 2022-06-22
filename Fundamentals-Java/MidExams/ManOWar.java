package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.
                stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Retire")) {
            String command = commandLine.split(" ")[0];
            int index;

            switch (command) {
                case "Fire":
                    index = Integer.parseInt(commandLine.split(" ")[1]);
                    int damage = Integer.parseInt(commandLine.split(" ")[2]);

                    if (index >= 0 && index <= warShip.size() - 1) {
                    int warShipSectionHealth = warShip.get(index) - damage;

                        if (warShipSectionHealth > 0) {
                            warShip.set(index, warShipSectionHealth);
                        } else {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commandLine.split(" ")[1]);
                    int endIndex = Integer.parseInt(commandLine.split(" ")[2]);
                    int damageReceived = Integer.parseInt(commandLine.split(" ")[3]);

                    if (( startIndex >= 0 && startIndex <= pirateShip.size() - 1) && (endIndex >= 0 && endIndex <= pirateShip.size() - 1) && startIndex < endIndex) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int pirateShipSectionHealth = pirateShip.get(i) - damageReceived;
                            if (pirateShipSectionHealth > 0){
                                pirateShip.set(i, pirateShipSectionHealth);
                            } else {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(commandLine.split(" ")[1]);
                    int health = Integer.parseInt(commandLine.split(" ")[2]);

                    if (index >= 0 && index <= pirateShip.size() - 1){
                        int repair = pirateShip.get(index) + health;
                        if (pirateShip.get(index) + health > maxHealthCapacity){
                            repair = maxHealthCapacity;
                        }
                        pirateShip.set(index, repair);
                    }
                    break;
                case "Status":
                    int needsRepair = maxHealthCapacity * 20 / 100;
                    int countRepair = 0;
                    for (int section : pirateShip) {
                        if (section < needsRepair) {
                            countRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", countRepair);
                    break;
            }
            commandLine = scanner.nextLine();

        }
        System.out.printf("Pirate ship status: %d%n", shipStatus(pirateShip));
        System.out.printf("Warship status: %d", shipStatus(warShip));
    }
    public static int shipStatus (List<Integer> ship){
        int sum = 0;
        for (int section : ship){
            sum += section;
        }
        return sum;
    }
}
