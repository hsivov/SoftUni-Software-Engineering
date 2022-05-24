package OnlinePreExam19and20March2022;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computers = Integer.parseInt(scanner.nextLine());
        double totalSales = 0;

        int rating = 0;

        for (int i = 1; i <= computers; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            int last = number % 10;
            int firstTwo = number / 10;
            double sales = 0;

            switch (last) {
                case 2:
                    sales = 0;
                    rating += 2;
                    break;
                case 3:
                    sales = firstTwo * 0.5;
                    rating += 3;
                    break;
                case 4:
                    sales = firstTwo * 0.7;
                    rating += 4;
                    break;
                case 5:
                    sales = firstTwo * 0.85;
                    rating += 5;
                    break;
                case 6:
                    sales = firstTwo;
                    rating += 6;
                    break;
            }
            totalSales += sales;
        }
        double averageRating = rating * 1.00 / computers;
        System.out.printf("%.2f%n", totalSales);
        System.out.printf("%.2f", averageRating);
    }
}
