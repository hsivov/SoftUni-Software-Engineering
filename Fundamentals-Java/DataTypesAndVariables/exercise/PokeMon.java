package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialPower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokeCount = 0;
        int max = Integer.MAX_VALUE;

        int power = initialPower;

        while (power >= distance) {
            power -= distance;
            pokeCount++;
            if (power / (initialPower * 1.00) == 0.5) {
                if (exhaustionFactor > 0) {
                    power = power / exhaustionFactor;
                    //power /= exhaustionFactor;
                }
            }
        }
        System.out.println(power);
        System.out.println(pokeCount);
        System.out.println(max);
    }
}
