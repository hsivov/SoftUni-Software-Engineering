package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolMap = new TreeMap<>();

        char[] text = scanner.nextLine().toCharArray();

        for (char currentSymbol : text) {
            if (!symbolMap.containsKey(currentSymbol)) {
                symbolMap.put(currentSymbol, 1);
            } else {
                symbolMap.put(currentSymbol, symbolMap.get(currentSymbol) + 1);
            }
        }
        symbolMap.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
