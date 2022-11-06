package InterfacesAndAbstraction.border;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String id;
            Identifiable identifiable;

            if (data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                id = data[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = data[0];
                id = data[1];
                identifiable = new Robot(id, model);
            }
            identifiables.add(identifiable);
            input = scanner.nextLine();
        }
        String fakeIds = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIds))
                .forEach(System.out::println);
    }
}
