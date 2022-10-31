package Exams.JavaAdvancedExam_25June2022;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> chocolatesMap = new TreeMap<>();

        ArrayDeque<Double> milkValuesQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoValuesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).forEach(cacaoValuesStack::push);

        while (!milkValuesQueue.isEmpty() && !cacaoValuesStack.isEmpty()) {
            double milkValue = milkValuesQueue.poll();
            double cacaoValue = cacaoValuesStack.pop();

            double result = cacaoValue /(milkValue + cacaoValue);

            if (result == 1) {
                int count = chocolatesMap.getOrDefault("Baking Chocolate", 0);
                chocolatesMap.put("Baking Chocolate", count + 1);
            } else if (result == 0.5) {
                int count = chocolatesMap.getOrDefault("Dark Chocolate", 0);
                chocolatesMap.put("Dark Chocolate", count + 1);
            } else if (result == 0.3) {
                int count = chocolatesMap.getOrDefault("Milk Chocolate", 0);
                chocolatesMap.put("Milk Chocolate", count + 1);
            } else {
                milkValue += 10;
                milkValuesQueue.offer(milkValue);
            }
        }

        if (chocolatesMap.size() < 3) {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            chocolatesMap.forEach((k, v) -> System.out.printf("# %s --> %d%n", k, v));
        } else {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            chocolatesMap.forEach((k, v) -> System.out.printf("# %s --> %d%n", k, v));
        }
    }
}
