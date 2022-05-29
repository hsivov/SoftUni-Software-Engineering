package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int spiceYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int total = 0;

        while (spiceYield >= 100) {
            int extracted = spiceYield - 26;
            total += extracted;
            spiceYield -= 10;
            days++;
        }
        if (total >= 26) {
            total -= 26;
        }
        System.out.println(days);
        System.out.println(total);
    }
}
