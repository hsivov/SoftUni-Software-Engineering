package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            if (!phonebook.containsKey(name)) {
                phonebook.put(name, number);
            } else {
                phonebook.put(phonebook.get(name), number);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {

            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
