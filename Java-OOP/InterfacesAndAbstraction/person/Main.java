package InterfacesAndAbstraction.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String type = data[0];
            String name = data[1];
            String birthdate;
            Birthable birthable;

            switch (type) {
                case "Citizen":
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    birthdate = data[4];
                    birthable = new Citizen(name, age, id, birthdate);
                    birthables.add(birthable);
                    break;
                case "Robot":
                    break;
                case "Pet":
                    birthdate = data[2];
                    birthable = new Pet(name, birthdate);
                    birthables.add(birthable);
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        birthables.stream()
                .map(Birthable::getBirthDate)
                .filter(e -> e.endsWith(year))
                .forEach(System.out::println);
    }
}
