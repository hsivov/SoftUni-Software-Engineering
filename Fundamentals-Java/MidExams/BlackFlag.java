package MidExams;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysPirating = Integer.parseInt(scanner.nextLine());
        int plunderForDay = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0;

        for (int day = 1; day <= daysPirating; day++) {
            totalPlunder += plunderForDay;
            if (day % 3 == 0){
                totalPlunder = totalPlunder + plunderForDay * 0.5;
            }
            if (day % 5 == 0){
                totalPlunder = totalPlunder - totalPlunder * 0.3;
            }
        }

        if (totalPlunder >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.",100 - (expectedPlunder - totalPlunder) / expectedPlunder * 100);
        }
    }
}
