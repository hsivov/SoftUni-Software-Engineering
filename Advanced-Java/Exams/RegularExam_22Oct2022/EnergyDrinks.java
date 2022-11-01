package Exams.RegularExam_22Oct2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> caffeineMgStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(caffeineMgStack::push);

        ArrayDeque<String> energyDrinksQueue = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int limitMax = 300;
        int caffeine = 0;

        while (!caffeineMgStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
            int caffeineMg = Integer.parseInt(caffeineMgStack.pop());
            int energyDrink = Integer.parseInt(energyDrinksQueue.poll());

            int result = caffeineMg * energyDrink;

            if (caffeine + result > limitMax) {
                energyDrinksQueue.offer(String.valueOf(energyDrink));
                if (caffeine >= 30) {
                    caffeine -= 30;
                }
                continue;
            }
            caffeine += result;
        }

        if (energyDrinksQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.println("Drinks left: " + String.join(", ", energyDrinksQueue));
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeine);
    }
}
