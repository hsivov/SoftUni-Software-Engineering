package AssociativeArrays.more;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contestMap = new LinkedHashMap<>();
        Map<String, Integer> standings = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("no more time")) {
            String userName = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (contestMap.containsKey(contest)) {
                if (contestMap.get(contest).containsKey(userName)) {
                    int currentPoints = contestMap.get(contest).get(userName);
                    if (currentPoints < points) {
                        contestMap.get(contest).put(userName, points);
                    }
                } else {
                    contestMap.get(contest).put(userName, points);
                }
            } else {
                contestMap.put(contest, new TreeMap<>());
                contestMap.get(contest).put(userName, points);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> contest : contestMap.entrySet()) {
            System.out.printf("%s: %d participants%n", contest.getKey(), contest.getValue().size());

            int position = 1;
            for (Map.Entry<String, Integer> name : sortByValue(contest.getValue()).entrySet()) {
                System.out.printf("%d. %s <::> %d%n", position++, name.getKey(), name.getValue());
            }
        }
        System.out.println("Individual standings:");

        for (Map.Entry<String, Map<String, Integer>> contest : contestMap.entrySet()) {
            for (Map.Entry<String, Integer> name : contest.getValue().entrySet()) {
                if (!standings.containsKey(name.getKey())) {
                    standings.put(name.getKey(), name.getValue());
                } else {
                    int oldValue = standings.get(name.getKey());
                    standings.put(name.getKey(), name.getValue() + oldValue);
                }
            }

        }
        int pos = 1;
        for (Map.Entry<String, Integer> entry : sortByValue(standings).entrySet()) {
            System.out.printf("%d. %s -> %d%n", pos++, entry.getKey(), entry.getValue());
        }
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        // create new hashmap to store sorted data
        HashMap<String, Integer> temp = new LinkedHashMap<>();

        // Sort the map
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> temp.put(entry.getKey(), entry.getValue()));
        //return sorted data
        return temp;
    }
}
