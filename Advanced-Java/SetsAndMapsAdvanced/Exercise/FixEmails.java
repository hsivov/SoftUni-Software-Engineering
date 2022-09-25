package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Set<String> banned = new HashSet<>(Arrays.asList("us", "uk", "com"));
        Map<String, String> emailsByName = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            String[] emailPart = email.split("\\.");

            if (!banned.contains(emailPart[emailPart.length - 1])) {
                emailsByName.put(name, email);
            }
            name = scanner.nextLine();
        }
        emailsByName.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
