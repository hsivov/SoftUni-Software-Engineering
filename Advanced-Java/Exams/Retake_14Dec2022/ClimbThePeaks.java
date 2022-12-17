package Exams.Retake_14Dec2022;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> foodPortions = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(foodPortions::push);

        Deque<String> stamina = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> peeks = new LinkedHashMap<>();
        peeks.put("Vihren", 80);
        peeks.put("Kutelo", 90);
        peeks.put("Banski Suhodol", 100);
        peeks.put("Polezhan", 60);
        peeks.put("Kamenitza", 70);

        int day = 1;
        boolean isGoalReached = false;

        Set<String> conqueredPeeks = new LinkedHashSet<>();

        while (day <= 7 && !foodPortions.isEmpty() && !stamina.isEmpty()) {
            int portion = Integer.parseInt(foodPortions.pop());
            int dailyStamina = Integer.parseInt(stamina.poll());

            int result = portion + dailyStamina;

            Map.Entry<String, Integer> entry = peeks.entrySet().iterator().next();
            String peek = entry.getKey();
            int difficulty = entry.getValue();

            if (result >= difficulty) {
                conqueredPeeks.add(peek);
                peeks.remove(peek);
            } else {
                day++;
            }

            if (conqueredPeeks.size() == 5) {
                isGoalReached = true;
                break;
            }
        }

        if (isGoalReached) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeeks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String conqueredPeek : conqueredPeeks) {
                System.out.println(conqueredPeek);
            }
        }
    }
}
