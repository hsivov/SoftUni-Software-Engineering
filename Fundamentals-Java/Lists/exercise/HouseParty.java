package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsNumber = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int commandIndex = 0; commandIndex < commandsNumber; commandIndex++) {
            String input = scanner.nextLine();

            String name = input.split(" ")[0];
            if (input.contains("is going!")) {
                if (guestList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestList.add(name);
                }
            } else if (input.contains("is not going")) {
                if (guestList.contains(name)) {
                    guestList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}


