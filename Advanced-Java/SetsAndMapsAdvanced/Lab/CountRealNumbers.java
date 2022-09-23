package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbers) {
            if (!numbersMap.containsKey(number)) {
                numbersMap.put(number, 1);
            } else {
                numbersMap.put(number, numbersMap.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
