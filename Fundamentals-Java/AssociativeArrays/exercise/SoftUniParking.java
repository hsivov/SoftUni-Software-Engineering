package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> userMap = new LinkedHashMap<>();

        for (int line = 1; line <= n; line++) {
            String commandLine = scanner.nextLine();
            String command = commandLine.split(" ")[0];
            String userName = commandLine.split(" ")[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = commandLine.split(" ")[2];
                    if (isUserAlreadyRegistered(userMap, userName)){
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        userMap.put(userName, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (isUserPresentInDatabase(userMap, userName)){
                        userMap.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", userName);
                    }
                    break;
            }
        }
        userMap.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }

    private static boolean isUserPresentInDatabase(Map<String, String> map, String user) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(user)){
                return true;
            }
        }
        return false;
    }

    private static boolean isUserAlreadyRegistered(Map<String, String> map, String user){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(user)){
                return true;
            }
        }
        return false;
    }
}
