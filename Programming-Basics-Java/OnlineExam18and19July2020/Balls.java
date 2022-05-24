package OnlineExam18and19July2020;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalPoints = 0;
        int countRed = 0;
        int countOrange = 0;
        int countYellow = 0;
        int countWhite = 0;
        int countBlack = 0;
        int countOther = 0;

        for (int i = 0; i < n; i++) {
            String color = scanner.nextLine();

            switch (color){
                case "red":
                    countRed++;
                    totalPoints += 5;
                    break;
                case "orange":
                    countOrange++;
                    totalPoints += 10;
                    break;
                case "yellow":
                    countYellow++;
                    totalPoints += 15;
                    break;
                case "white":
                    countWhite++;
                    totalPoints += 20;
                    break;
                case "black":
                    countBlack++;
                    totalPoints = totalPoints / 2;
                    break;

                default:
                    countOther++;
                    break;
            }
        }

        System.out.printf("Total points: %d%n", totalPoints);
        System.out.printf("Red balls: %d%n", countRed);
        System.out.printf("Orange balls: %d%n", countOrange);
        System.out.printf("Yellow balls: %d%n", countYellow);
        System.out.printf("White balls: %d%n", countWhite);
        System.out.printf("Other colors picked: %d%n", countOther);
        System.out.printf("Divides from black balls: %d", countBlack);
    }
}
