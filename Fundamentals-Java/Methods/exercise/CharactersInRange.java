package Methods.exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        if (isFirstLowIndex(first, second)) {
            for (int symbol = first + 1; symbol < second; symbol++) {
                System.out.printf("%c ", symbol);
            }
        } else {
            for (int symbol = second + 1; symbol < first; symbol++) {
                System.out.printf("%c ", symbol);
            }
        }
    }

    private static boolean isFirstLowIndex(char first, char second) {

        return first < second;
    }
}
