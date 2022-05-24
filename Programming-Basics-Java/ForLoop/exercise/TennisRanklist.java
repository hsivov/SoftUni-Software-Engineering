package ForLoop.exercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int games = Integer.parseInt(scanner.nextLine());
        int initialPoints = Integer.parseInt(scanner.nextLine());

        int points = 0;
        int wins = 0;

        for (int i = 0; i < games; i++) {
            String type = scanner.nextLine();

            switch (type) {
                case "W":
                    points += 2000;
                    wins++;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points += 720;
                    break;
            }
        }

        double winPercent = wins * 1.00 / games * 100;
        int totalPoints = initialPoints + points;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %d%n", points / games);
        System.out.printf("%.2f%%", winPercent);
    }
}
