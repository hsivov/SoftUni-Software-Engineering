package WhileLoop.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double savedMoney = Double.parseDouble(scanner.nextLine());
        int spendDays = 0;
        int days = 0;

        while (savedMoney < neededMoney && spendDays < 5) {

            String action = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            days++;

            if (action.equals("spend")) {
                spendDays++;
                savedMoney -= money;
                if (savedMoney < 0) {
                    savedMoney = 0;
                }
            } else if (action.equals("save")) {
                savedMoney += money;
                spendDays = 0;
            }
        }

        if (savedMoney >= neededMoney) {
            System.out.printf("You saved the money for %d days.", days);
        }
        if (spendDays == 5) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }
    }
}
