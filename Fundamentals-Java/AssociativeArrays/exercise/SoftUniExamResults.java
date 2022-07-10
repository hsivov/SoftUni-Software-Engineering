package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userNameMap = new LinkedHashMap<>();
        Map<String, Integer> languageMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String name = input.split("-")[0];
            String language = input.split("-")[1];


            if (!language.equals("banned")) {
                if (!languageMap.containsKey(language)) {
                    languageMap.put(language, 1);
                } else {
                    languageMap.put(language, languageMap.get(language) + 1);
                }

                int points = Integer.parseInt(input.split("-")[2]);
                if (!userNameMap.containsKey(name)) {
                    userNameMap.put(name, points);
                } else {
                    int currentPoints = userNameMap.get(name);
                    if (points > currentPoints) {
                        userNameMap.put(name, points);
                    }
                }
            } else {
                userNameMap.remove(name);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : userNameMap.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
