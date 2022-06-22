package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        double average = sum * 1.00 / integerList.size();
        int index = 5;      //индексът след който ще премахваме останалите елементи, трябват ни само първите 5

        integerList.removeIf(e -> e <= average);
        Collections.sort(integerList);
        Collections.reverse(integerList);

        if (integerList.size() - 1 > index) {
            integerList.subList(index, integerList.size()).clear();
        }
        if (!integerList.isEmpty()) {
            System.out.println(integerList.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("No");
        }
    }
}
