package OnlineExam18and19July2020;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        int kidTickets = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

        double kidTicketsPrice = ((price - price * 0.7) + tax) * kidTickets;
        double ticketsPrice = tickets * (price + tax);
        double total = ticketsPrice + kidTicketsPrice;
        double profit = total * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);

    }
}
