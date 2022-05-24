package basicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

                switch (type){
                    case "Students":
                        switch (day){
                            case "Friday":
                                price = 8.45;
                                if (numberOfPeople >= 30){
                                    price = price * 0.85;
                                }
                                break;
                            case "Saturday":
                                price = 9.80;
                                if (numberOfPeople >= 30){
                                    price = price * 0.85;
                                }
                                break;
                            case "Sunday":
                                price = 10.46;
                                if (numberOfPeople >= 30){
                                    price = price * 0.85;
                                }
                                break;
                        }
                        break;
                    case "Business":
                        switch (day){
                            case "Friday":
                                price = 10.90;
                                if (numberOfPeople >= 100){
                                    numberOfPeople -= 10;
                                }
                                break;
                            case "Saturday":
                                price = 15.60;
                                if (numberOfPeople >= 100){
                                    numberOfPeople -= 10;
                                }
                                break;
                            case "Sunday":
                                price = 16;
                                if (numberOfPeople >= 100){
                                    numberOfPeople -= 10;
                                }
                                break;
                        }
                        break;
                    case "Regular":
                        switch (day){
                            case "Friday":
                                price = 15;
                                if (numberOfPeople >= 10 && numberOfPeople < 20){
                                    price = price * 0.95;
                                }
                                break;
                            case "Saturday":
                                price = 20;
                                if (numberOfPeople >= 10 && numberOfPeople < 20){
                                    price = price * 0.95;
                                }
                                break;
                            case "Sunday":
                                price = 22.50;
                                if (numberOfPeople >= 10 && numberOfPeople < 20){
                                    price = price * 0.95;
                                }
                                break;
                        }
                        break;
        }
        double totalPrice = numberOfPeople * price;
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
