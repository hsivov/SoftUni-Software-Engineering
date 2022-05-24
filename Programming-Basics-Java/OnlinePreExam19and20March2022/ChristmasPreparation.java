package OnlinePreExam19and20March2022;

import java.util.Scanner;

public class ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paper = Integer.parseInt(scanner.nextLine());
        int fabric = Integer.parseInt(scanner.nextLine());
        double glue = Double.parseDouble(scanner.nextLine());
        double discountPercent = Double.parseDouble(scanner.nextLine());

        double price = paper * 5.80 + fabric * 7.20 + glue * 1.20;
        price = price - price * discountPercent / 100;

        System.out.printf("%.3f", price);
    }
}
