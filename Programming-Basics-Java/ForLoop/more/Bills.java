package ForLoop.more;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalElectricity = 0;
        double totalOther = 0;
        double water = 20;
        double internet = 15;
        int months = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < months; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            totalElectricity += electricity;
            double other = (electricity + water + internet) * 1.20;
            totalOther += other;
        }
        water = water * months;
        internet = internet * months;
        double average = (totalElectricity + water + internet + totalOther) / months;

        System.out.printf("Electricity: %.2f lv%n", totalElectricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", totalOther);
        System.out.printf("Average: %.2f lv", average);
    }
}
