package ConditionalStatements.exercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        int episodeLength = Integer.parseInt(scanner.nextLine());
        int restTime = Integer.parseInt(scanner.nextLine());

        double time = restTime - restTime * 1.00 / 8 - restTime * 1.00 / 4;

        if (time >= episodeLength) {
            System.out.printf("You have enough time to watch %s" +
                    " and left with %.0f minutes free time.", title, Math.ceil(time - episodeLength));
        } else {
            System.out.printf("You don't have enough time to watch %s," +
                    " you need %.0f more minutes.", title, Math.ceil(episodeLength - time));
        }
    }
}
