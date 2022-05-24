package ForLoop.exercise;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countP1 = 0;
        int countP2 = 0;
        int countP3 = 0;
        int countP4 = 0;
        int countP5 = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 200) {
                countP1++;
            } else if (num < 400) {
                countP2++;
            } else if (num < 600) {
                countP3++;
            } else if (num < 800) {
                countP4++;
            } else {
                countP5++;
            }
        }
        double p1 = countP1 * 1.00 / n * 100;
        double p2 = countP2 * 1.00 / n * 100;
        double p3 = countP3 * 1.00 / n * 100;
        double p4 = countP4 * 1.00 / n * 100;
        double p5 = countP5 * 1.00 / n * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
        System.out.printf("%.2f%%%n", p4);
        System.out.printf("%.2f%%%n", p5);
    }
}
