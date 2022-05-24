package OnlineExam6And7July2019;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int maxResult = 0;
        String winner = "";

        while (!name.equals("Stop")) {
            int playerPoints = 0;

            for (int i = 0; i < name.length(); i++) {
                int num = Integer.parseInt(scanner.nextLine());
                char letter = name.charAt(i);

                if (letter == num) {
                    playerPoints += 10;
                } else {
                    playerPoints += 2;
                }
            }
            if (playerPoints >= maxResult) {
                maxResult = playerPoints;
                winner = name;
            }
            name = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, maxResult);
    }
}
