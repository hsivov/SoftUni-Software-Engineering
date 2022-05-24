package ConditionalStatementsAdvanced.more;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int groupSize = Integer.parseInt(scanner.nextLine());
        double ticketsPrice = 0;
        double transport = 0;

        switch (category){
            case "VIP":
                if (groupSize < 5){
                    ticketsPrice = groupSize * 499.99;
                    transport = budget*0.75;
                }else if(groupSize < 10){
                    ticketsPrice = groupSize * 499.99;
                    transport = budget*0.60;
                }else if (groupSize < 25){
                    ticketsPrice = groupSize * 499.99;
                    transport = budget*0.50;
                }else if (groupSize < 50){
                    ticketsPrice = groupSize * 499.99;
                    transport = budget*0.40;
                }else{
                    ticketsPrice = groupSize * 499.99;
                    transport = budget*0.25;
                }
                break;
            case "Normal":
                if (groupSize < 5){
                    ticketsPrice = groupSize * 249.99;
                    transport = budget*0.75;
                }else if(groupSize < 10){
                    ticketsPrice = groupSize * 249.99;
                    transport = budget*0.60;
                }else if (groupSize < 25){
                    ticketsPrice = groupSize * 249.99;
                    transport = budget*0.50;
                }else if (groupSize < 50){
                    ticketsPrice = groupSize * 249.99;
                    transport = budget*0.40;
                }else{
                    ticketsPrice = groupSize * 249.99;
                    transport = budget*0.25;
                }
                break;
        }
        double totalCosts = ticketsPrice + transport;
        if (budget >= totalCosts){
            System.out.printf("Yes! You have %.2f leva left.", budget - totalCosts);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.", totalCosts - budget);
        }
    }
}
