package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMessages = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int message = 0; message < countMessages; message++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);

            String regex = "@(?<planetName>[A-za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiers>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                //int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                //int soldiersCount = Integer.parseInt(matcher.group("soldiers"));

                if (attackType.equals("A")){
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecryptedMessage(String encryptedMessage) {
        int countLetters = getSpecialLettersCount(encryptedMessage);

        StringBuilder decryptedMessage = new StringBuilder();

        for (char symbol : encryptedMessage.toCharArray()){
            char newSymbol = (char) (symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLettersCount(String encryptedMessage) {
        int count = 0;
        encryptedMessage = encryptedMessage.toLowerCase();
        for (char symbol : encryptedMessage.toCharArray()){
            if (symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r'){
                count++;
            }
        }
        return count;
    }
}
