package Exams.JavaAdvancedRetakeExam_17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class PresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> presents = new TreeMap<>();
        Deque<String> materialsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(materialsStack::push);

        Deque<String> magicQueue = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));
        boolean isDone = false;

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) {
            int material = Integer.parseInt(materialsStack.pop());
            int magic = Integer.parseInt(magicQueue.poll());

            int magicLevel = material * magic;

            String present;


            if (magicLevel < 0) {
                int sum = material + magic;
                materialsStack.push(String.valueOf(sum));
            } else if (magicLevel > 0) {
                switch (magicLevel) {
                    case 150:
                        present = "Doll";
                        addPresentToMap(presents, present);
                        break;
                    case 250:
                        present = "Wooden train";
                        addPresentToMap(presents, present);
                        break;
                    case 300:
                        present = "Teddy bear";
                        addPresentToMap(presents, present);
                        break;
                    case 400:
                        present = "Bicycle";
                        addPresentToMap(presents, present);
                        break;
                    default:
                        material += 15;
                        materialsStack.push(String.valueOf(material));
                }
            } else {
                if (material != 0) {
                    materialsStack.push(String.valueOf(material));
                }
                if (magic != 0) {
                    magicQueue.addFirst(String.valueOf(magic));
                }
            }
        }
        if ((presents.containsKey("Doll") && presents.containsKey("Wooden train")) || (presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"))) {
            isDone = true;
        }

        String out = isDone ? "The presents are crafted! Merry Christmas!"
                : "No presents this Christmas!";

        System.out.println(out);
        if (!materialsStack.isEmpty()) {
            System.out.println("Materials left: " + String.join(", ", materialsStack));
        }
        if (!magicQueue.isEmpty()) {
            System.out.println("Magic left: " + String.join(", ", magicQueue));
        }
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }

    private static void addPresentToMap(Map<String, Integer> presents, String present) {
        if (!presents.containsKey(present)) {
            presents.put(present, 1);
        } else {
            presents.put(present, presents.get(present) + 1);
        }
    }
}
