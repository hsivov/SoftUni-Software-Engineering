package WhileLoop.more;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requiredMoney = Integer.parseInt(scanner.nextLine());
        int transaction = 1;
        int cashPayment = 0;
        int cardPayment = 0;
        double totalCash = 0;
        double totalCard = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")){
            int amount = Integer.parseInt(input);

            if (transaction % 2 != 0){
                if (amount > 100){
                    System.out.println("Error in transaction!");
                }else{
                    totalCash += amount;
                    System.out.println("Product sold!");
                    cashPayment++;
                }
            }else{
                if (amount < 10){
                    System.out.println("Error in transaction!");
                }else {
                    totalCard += amount;
                    System.out.println("Product sold!");
                    cardPayment++;
                }
            }

            if ((totalCash + totalCard) >= requiredMoney){
                double averageCash = totalCash / cashPayment;
                double averageCard = totalCard / cardPayment;
                System.out.printf("Average CS: %.2f%n", averageCash);
                System.out.printf("Average CC: %.2f", averageCard);
                break;
            }

            transaction++;
            input = scanner.nextLine();
        }
        if ((totalCash + totalCard) < requiredMoney) {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
