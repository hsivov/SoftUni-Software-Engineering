package ForLoop.more;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        int sectorA = 0;
        int sectorB = 0;
        int sectorV = 0;
        int sectorG = 0;

        for (int i = 0; i < fans; i++) {
            String sector = scanner.nextLine();

            if ("A".equals(sector)) {
                sectorA++;
            } else if ("B".equals(sector)) {
                sectorB++;
            } else if ("V".equals(sector)) {
                sectorV++;
            } else if ("G".equals(sector)) {
                sectorG++;
            }
        }
        double percentSectorA = sectorA * 1.00 / fans * 100;
        double percentSectorB = sectorB * 1.00 / fans * 100;
        double percentSectorV = sectorV * 1.00 / fans * 100;
        double percentSectorG = sectorG * 1.00 / fans * 100;
        double total = fans * 1.00/ capacity * 100;

        System.out.printf("%.2f%%%n", percentSectorA);
        System.out.printf("%.2f%%%n", percentSectorB);
        System.out.printf("%.2f%%%n", percentSectorV);
        System.out.printf("%.2f%%%n", percentSectorG);
        System.out.printf("%.2f%%", total);
    }
}
