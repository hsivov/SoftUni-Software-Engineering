package ForLoop.more;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loads = Integer.parseInt(scanner.nextLine());
        double total = 0;
        int bus = 0;
        int truck = 0;
        int train = 0;

        for (int i = 0; i < loads; i++) {
            int tonnage = Integer.parseInt(scanner.nextLine());
            total += tonnage;

            if (tonnage <= 3) {
                bus += tonnage;
            } else if (tonnage <= 11) {
                truck += tonnage;
            } else {
                train += tonnage;
            }
        }
        double averagePrice = (bus * 200 + truck * 175 + train * 120) / total;
        double busPercent = bus / total * 100;
        double truckPercent = truck / total * 100;
        double trainPercent = train / total * 100;
        System.out.printf("%.2f%n", averagePrice);
        System.out.printf("%.2f%%%n", busPercent);
        System.out.printf("%.2f%%%n", truckPercent);
        System.out.printf("%.2f%%", trainPercent);
    }
}
