package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daemonNames = scanner.nextLine().split("\\s*,\\s*");

        Pattern patternHealth = Pattern.compile("[^0-9+\\-*/.]");
        Pattern patternDamage = Pattern.compile("-?\\+?\\d+[.]?\\d*");

        for (String daemon : daemonNames) {
            Matcher matcherHealth = patternHealth.matcher(daemon);
            int health = 0;
            while (matcherHealth.find()){
                char symbol = matcherHealth.group().charAt(0);
                health += symbol;
            }

            Matcher matcherDamage = patternDamage.matcher(daemon);
            double damage = 0.0;
            while (matcherDamage.find()){
                damage += Double.parseDouble(matcherDamage.group());
            }

            for (char symbol : daemon.toCharArray()){
                if (symbol == '/'){
                    damage /= 2;
                } else if (symbol == '*') {
                    damage *= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", daemon, health, damage);
        }
    }
}
