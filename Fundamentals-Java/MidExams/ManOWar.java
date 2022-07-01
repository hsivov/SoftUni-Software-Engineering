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

        int maxHealth = Integer.parseInt(scanner.nextLine());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Retire")) {
            String command = commandLine.split(" ")[0];
            int index = Integer.parseInt(commandLine.split(" ")[1]);

            switch (command) {
                case "Fire":
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

                    if ((startIndex <= pirateShip.size() - 1) && (endIndex <= pirateShip.size() - 1) && startIndex < endIndex) {
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

                    break;
                case "Status":
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println(pirateShip);
    }
}
