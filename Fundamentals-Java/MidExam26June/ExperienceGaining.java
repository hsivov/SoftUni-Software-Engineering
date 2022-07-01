package MidExam26June;

import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double experienceNeeded = Double.parseDouble(scanner.nextLine());
        int countBattles = Integer.parseInt(scanner.nextLine());

        double experience = 0;
        boolean isGained = false;

        int battleCount = 0;
        for (int i = 1; i <= countBattles; i++) {
            double currentBattle = Double.parseDouble(scanner.nextLine());
            battleCount++;

            if (i % 3 == 0) {
                currentBattle = currentBattle * 1.15;
            }
            if (i % 5 == 0){
                currentBattle = currentBattle * 0.90;
            }
            if (i % 15 == 0){
                currentBattle = currentBattle * 1.05;
            }
            experience += currentBattle;

            if (experience >= experienceNeeded){
                isGained = true;
                break;
            }
        }
        if(isGained){
            System.out.printf("Player successfully collected his needed experience for %d battles.", battleCount);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", experienceNeeded - experience);
        }
    }
}
