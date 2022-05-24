package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int price = 0;
        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Friday")){
            price = 12;
        }else if (day.equals("Wednesday") || day.equals("Thursday")){
            price = 14;
        }else if (day.equals("Saturday") || day.equals("Sunday")){
            price = 16;
        }
        System.out.println(price);
    }
}
