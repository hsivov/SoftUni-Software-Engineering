package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lengths = scanner.nextLine();

        int firstLength = Integer.parseInt(lengths.split(" ")[0]);
        int secondLength = Integer.parseInt(lengths.split(" ")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>(firstLength);
        Set<Integer> secondSet = new LinkedHashSet<>(secondLength);
        List<Integer> repeatedElements = new ArrayList<>();

        for (int i = 0; i < firstLength; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNumber);
        }
        for (int i = 0; i < secondLength; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNumber);
        }

        for (Integer element : firstSet) {
            if (secondSet.contains(element)) {
                repeatedElements.add(element);
            }
        }
        repeatedElements.forEach(element -> System.out.print(element + " "));
    }
}
