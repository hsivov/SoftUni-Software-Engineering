package ExamPreparation.JavaAdvancedRetakeExam_18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlatesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(carsStack::push);

        int days = 0;
        int registeredCars = 0;

        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {

            int plates = licensePlatesQueue.poll();
            int cars = carsStack.pop();

            int diff = cars - plates / 2;

            if (diff == 0) {
                registeredCars += cars;

            } else if (diff > 0) {
                registeredCars += cars - diff;

                carsStack.addLast(diff);
            } else {
                registeredCars += cars;

                licensePlatesQueue.offer(plates - cars * 2);
            }
            days++;
        }

        int platesLeft = licensePlatesQueue.stream().mapToInt(Integer::valueOf).sum();
        int carsLeft = carsStack.stream().mapToInt(Integer::valueOf).sum();


        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (platesLeft > 0) {
            System.out.printf("%d license plates remain!", platesLeft);
        } else if (carsLeft > 0) {
            System.out.printf("%d cars remain without license plates!", carsLeft);
        } else if (platesLeft == 0 && carsLeft == 0) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
