package AssociativeArrays.more;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestMap = new HashMap<>();
        Map<String, Map<String, Integer>> userMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String contestName = input.split(":")[0];
            String password = input.split(":")[1];

            contestMap.put(contestName, password);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String contestName = input.split("=>")[0];
            String password = input.split("=>")[1];
            String userName = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (isValidContest(contestName, contestMap)) {
                if (isCorrectPassword(contestName, password, contestMap)) {
                    if (userExist(userName, userMap)) {
                        if (isSameContest(userMap, userName, contestName)) {
                            int currentPoints = userMap.get(userName).get(contestName);
                            if (currentPoints < points) {
                                userMap.get(userName).put(contestName, points);
                            }
                        } else {
                            userMap.get(userName).put(contestName, points);
                        }
                    } else {
                        userMap.put(userName, new HashMap<>());
                        userMap.get(userName).put(contestName, points);
                    }
                }
            }
            input = scanner.nextLine();
        }
        printBestCandidate(userMap);
        System.out.println("Ranking:");

        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> innerEntry : sortByValue(entry.getValue()).entrySet()) {
                System.out.printf("#  %s -> %d%n", innerEntry.getKey(), innerEntry.getValue());
            }
        }
    }

    private static boolean isSameContest(Map<String, Map<String, Integer>> userMap, String userName, String contestName) {
        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            if (entry.getKey().equals(userName)) {
                for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                    if (innerEntry.getKey().equals(contestName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean userExist(String userName, Map<String, Map<String, Integer>> userMap) {
        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            if (entry.getKey().contains(userName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectPassword(String contest, String password, Map<String, String> contestMap) {
        for (Map.Entry<String, String> entry : contestMap.entrySet()) {
            if (entry.getValue().equals(password) && entry.getKey().equals(contest)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidContest(String contestName, Map<String, String> contestMap) {
        for (Map.Entry<String, String> entry : contestMap.entrySet()) {
            if (entry.getKey().equals(contestName)) {
                return true;
            }
        }
        return false;
    }

    private static void printBestCandidate(Map<String, Map<String, Integer>> userMap) {
        int best = 0;
        String bestCandidate = "";
        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            int currentPoints = 0;
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                currentPoints += innerEntry.getValue();
                if (currentPoints > best) {
                    best = currentPoints;
                    bestCandidate = entry.getKey();
                }
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, best);
    }

    // function to sort hashmap by values
    public static Map<String, Integer> sortByValue(Map<String, Integer> map)
    {
        List<Map.Entry<String, Integer> > list = new LinkedList<>(map.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
