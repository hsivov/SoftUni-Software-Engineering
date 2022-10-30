package ExamPreparation.JavaAdvancedExam_22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootbox = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootbox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(secondLootbox::push);

        int totalCollected = 0;
        while (!firstLootbox.isEmpty() && !secondLootbox.isEmpty()) {
            int firstItem = firstLootbox.peek();
            int secondItem = secondLootbox.pop();

            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                firstLootbox.poll();
                totalCollected += sum;
            } else {
                firstLootbox.offer(secondItem);
            }
        }

        String out = firstLootbox.isEmpty() ? "First lootbox is empty" : "Second lootbox is empty";
        String result = totalCollected >= 100
                ? String.format("Your loot was epic! Value: %d", totalCollected)
                : String.format("Your loot was poor... Value: %d", totalCollected);

        System.out.println(out);
        System.out.println(result);
    }
}
