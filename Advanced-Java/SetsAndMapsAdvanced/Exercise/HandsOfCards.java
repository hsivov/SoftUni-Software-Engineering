package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> playersMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] inputParts = input.split(": ");
            String name = inputParts[0];
            String[] cards = inputParts[1].split(", ");

            playersMap.putIfAbsent(name, new HashSet<>());

            Set<String> cardDeque = playersMap.get(name);
            cardDeque.addAll(List.of(cards));

            input = scanner.nextLine();
        }
        Map<String, Integer> cardsPower = new HashMap<>();
        populateCardPowerMap(cardsPower);

        Map<String, Integer> cardsType = new HashMap<>();
        populateCardTypeMap(cardsType);

        for (Map.Entry<String, HashSet<String>> player : playersMap.entrySet()) {
            String name = player.getKey();
            int points = calculatePoints(player.getValue(), cardsPower, cardsType);

            System.out.printf("%s: %d%n", name, points);
        }
    }

    private static int calculatePoints(HashSet<String> cards, Map<String, Integer> cardsPower, Map<String, Integer> cardsType) {
        int points = 0;
        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String cardType = card.substring(card.length() - 1);
            points += getCardPower(cardPower, cardsPower) * getCardType(cardType, cardsType);
        }
        return points;
    }

    private static int getCardType(String cardType, Map<String, Integer> cardsTypeMap) {
        return cardsTypeMap.get(cardType);
    }

    private static int getCardPower(String cardPower, Map<String, Integer> cardsPowerMap) {
        return cardsPowerMap.get(cardPower);
    }

    private static void populateCardTypeMap(Map<String, Integer> cardsType) {
        for (int i = 0; i < 4; i++) {
            cardsType.put("S", 4);
            cardsType.put("H", 3);
            cardsType.put("D", 2);
            cardsType.put("C", 1);
        }
    }

    private static void populateCardPowerMap(Map<String, Integer> cardsPower) {
        for (int i = 2; i <= 14; i++) {

            switch (i) {
                case 11:
                    cardsPower.put("J", 11);
                    break;
                case 12:
                    cardsPower.put("Q", 12);
                    break;
                case 13:
                    cardsPower.put("K", 13);
                    break;
                case 14:
                    cardsPower.put("A", 14);
                    break;
                default:
                    cardsPower.put(String.valueOf(i), i);
                    break;
            }
        }
    }
}
