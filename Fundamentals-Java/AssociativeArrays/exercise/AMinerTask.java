package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Integer> map = new LinkedHashMap<>();

        while (!input.equals("stop")){
            int value = Integer.parseInt(scanner.nextLine());
            if (!map.containsKey(input)) {
                map.put(input, value);
            } else {
                map.put(input, map.get(input) + value);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
