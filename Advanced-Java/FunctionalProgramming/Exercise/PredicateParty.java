package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] commandParts = command.split(" ");
            String doubleOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];

            Predicate<String> filterToApply = getPredicate(type, parameter);

            if (doubleOrRemove.equals("Remove")) {
                guests.removeIf(filterToApply);
            } else if (doubleOrRemove.equals("Double")) {
                for (int i = 0; i < guests.size(); i++) {
                    String guest = guests.get(i);
                    if (filterToApply.test(guest)) {
                        guests.add(i++, guest);
                    }
                }
            }
            command = scanner.nextLine();
        }
        Collections.sort(guests);

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {

        switch (type) {
            case "StartsWith":
                return s -> s.startsWith(parameter);
            case "EndsWith":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            default:
                throw new IllegalArgumentException();
        }
    }
}
