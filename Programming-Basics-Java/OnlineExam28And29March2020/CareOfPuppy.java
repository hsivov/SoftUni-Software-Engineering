package OnlineExam28And29March2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int food = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int eatenFood = 0;

        food = food * 1000;
        while (!input.equals("Adopted")) {
            int portion = Integer.parseInt(input);

            eatenFood += portion;

            input = scanner.nextLine();
        }
        if (eatenFood <= food) {
            System.out.printf("Food is enough! Leftovers: %d grams.", food - eatenFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", eatenFood - food);
        }
    }
}
