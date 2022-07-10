package AssociativeArrays.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")){
            if (input.contains("|")){
                String side = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];

                if (!map.containsKey(side)){
                    map.put(side, new ArrayList<>());
                    map.get(side).add(user);
                } else {
                    if (!isUserExist(map, user)){
                        map.get(side).add(user);
                    }
                }
            } else if (input.contains("->")) {
                String user = input.split(" -> ")[0];
                String side = input.split(" -> ")[1];

                if (isUserExist(map, user)) {
                    if (isSideExist(map, side)){
                        swapSides(map, user, side);
                    } else {
                        map.put(side, new ArrayList<>());
                        map.forEach((key, value) -> value.remove(user));
                        map.get(side).add(user);
                    }
                } else {
                    if (isSideExist(map, side)) {
                        map.get(side).add(user);
                    } else {
                        map.put(side, new ArrayList<>());
                        map.get(side).add(user);
                    }
                }
                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (String user : entry.getValue()) {
                    System.out.printf("! %s%n", user);
                }
            }
        }

    }

    private static boolean isSideExist(Map<String, List<String>> map, String side) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey().contains(side)){
                return true;
            }
        }
        return false;
    }

    private static void swapSides(Map<String, List<String>> map, String user, String side) {

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String member : entry.getValue()){
                if (member.equals(user)){
                    entry.getValue().remove(member);
                    break;
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey().contains(side)){
                entry.getValue().add(user);
            }
        }
    }

    private static boolean isUserExist(Map<String, List<String>> map, String user) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(user)){
                return true;
            }
        }
        return false;
    }
}
