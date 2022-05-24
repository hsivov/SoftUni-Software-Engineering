package OnlineExam6And7July2019;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String teamName = scanner.nextLine();
        int playedGames = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int countWins = 0;
        int countDraws = 0;
        int countLoses = 0;

        for (int i = 1; i <= playedGames; i++) {
            char result = scanner.nextLine().charAt(0);

            switch (result) {
                case 'W':
                    countWins++;
                    points += 3;
                    break;
                case 'D':
                    countDraws++;
                    points += 1;
                    break;
                case 'L':
                    countLoses++;
                    break;
            }
        }
        if (playedGames < 1) {
            System.out.printf("%s hasn't played any games during this season.", teamName);
        } else {
            System.out.printf("%s has won %d points during this season.%n", teamName, points);
            System.out.println("Total stats:");
            System.out.printf("## W: %d%n", countWins);
            System.out.printf("## D: %d%n", countDraws);
            System.out.printf("## L: %d%n", countLoses);
            System.out.printf("Win rate: %.2f%%", countWins * 1.00/ playedGames * 100);
        }
    }
}
