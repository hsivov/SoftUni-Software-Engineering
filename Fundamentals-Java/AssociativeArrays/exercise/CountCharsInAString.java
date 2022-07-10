package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        char[] symbols = text.replaceAll(" ", "").toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character symbol : symbols){
            if (!map.containsKey(symbol)){
                map.put(symbol, 1);
            } else {
                map.put(symbol, map.get(symbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
