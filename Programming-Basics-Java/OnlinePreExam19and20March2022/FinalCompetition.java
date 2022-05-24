package OnlinePreExam19and20March2022;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int members = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double profit = 0;

        switch (season){
            case "summer":
                switch (place){
                    case "Bulgaria":
                        profit = members * points;
                        profit = profit * 0.95;
                        break;
                    case "Abroad":
                        profit = (members * points) * 1.50;
                        profit = profit * 0.90;
                        break;
                }
                break;
            case "winter":
                switch (place){
                    case "Bulgaria":
                        profit = members * points;
                        profit = profit * 0.92;
                        break;
                    case "Abroad":
                        profit = (members * points) * 1.50;
                        profit = profit * 0.85;
                        break;
                }
                break;
        }
        double charity = profit * 0.75;
        profit -= charity;
        double moneyPerDancer = profit / members;

        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f", moneyPerDancer);
    }
}
