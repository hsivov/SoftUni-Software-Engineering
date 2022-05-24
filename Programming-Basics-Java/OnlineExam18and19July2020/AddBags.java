package OnlineExam18and19July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceBaggageOver20kg = Double.parseDouble(scanner.nextLine());
        double kilograms = Double.parseDouble(scanner.nextLine());
        int daysRemaining = Integer.parseInt(scanner.nextLine());
        int numberOfBaggage = Integer.parseInt(scanner.nextLine());
        double price = 0;

        if (kilograms < 10) {
            price = priceBaggageOver20kg * 0.2;
        } else if (kilograms >= 10 && kilograms <= 20) {
            price = priceBaggageOver20kg * 0.5;
        } else {
            price = priceBaggageOver20kg;
        }

        if (daysRemaining > 30){
            price = price * 1.10;
        }else if (daysRemaining >= 7){
            price = price * 1.15;
        }else{
            price = price * 1.40;
        }

        System.out.printf("The total price of bags is: %.2f lv. ", price * numberOfBaggage);
    }
}
