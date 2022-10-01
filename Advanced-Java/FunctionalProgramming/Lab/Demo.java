package FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String output = list.stream()
                .filter(integer -> integer <= 20 && integer > -20)
                .filter(integer -> integer != 0)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        Map<String, Double> map = new HashMap<>();
        map.put("Hristo", 5.50);
        map.put("Ivan", 6.00);
        map.put("Georgi", 3.25);
        map.put("Petar", 4.00);
        map.put("Asen", 4.00);


        Map<String, Double> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        System.out.println(output);
        sorted.forEach((key, value) -> System.out.println(key + " " + value));

        double a = 2;
        double b = -3;
        double c = 1;
        Function<Double, Double> quadFunc = x -> a * Math.pow(x, 2) + b * x + c;
        System.out.println(quadFunc.apply(1.0));
        System.out.println(getRoots(a, b, c));
    }

    private static Double getRoots(double a, double b, double c) {
        double d = Math.sqrt(Math.pow(b, 2) - 4 * a * c);

        return (-b + d) / (2 * a);
    }
}
