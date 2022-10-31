package WorkingWithAbstraction.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double pricePerDay = Double.parseDouble(input.split("\\s+")[0]);
        int days = Integer.parseInt(input.split("\\s+")[1]);
        Season season = Season.valueOf(input.split("\\s+")[2]);
        Discount discountType = Discount.valueOf(input.split("\\s+")[3]);

        System.out.printf("%.2f", PriceCalculator.calculateHolidayPrice(pricePerDay, days, season, discountType));
    }
}
