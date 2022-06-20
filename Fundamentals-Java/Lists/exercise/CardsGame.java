package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()){
            boolean isFirstBigger = firstDeck.get(0) > secondDeck.get(0);
            boolean isEqual = firstDeck.get(0).equals(secondDeck.get(0));
            int cardFirstDeck = firstDeck.get(0);
            int cardSecondDeck = secondDeck.get(0);

            if (isFirstBigger){
                firstDeck.add(cardFirstDeck);
                firstDeck.add(cardSecondDeck);
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else if (isEqual) {
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else {
                secondDeck.add(cardSecondDeck);
                secondDeck.add(cardFirstDeck);
                firstDeck.remove(0);
                secondDeck.remove(0);
            }

            if (firstDeck.isEmpty()){
                System.out.printf("Second player wins! Sum: %d", secondDeck.stream().mapToInt(Integer::intValue).sum());
                break;
            }
            if (secondDeck.isEmpty()){
                System.out.printf("First player wins! Sum: %d", firstDeck.stream().mapToInt(Integer::intValue).sum());
                break;
            }
        }
    }
}
