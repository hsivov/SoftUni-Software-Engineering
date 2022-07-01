package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Прочитане на монетите до команда Start
        //2. Сумиране на цялата сума
        //3. Приемат се само монети от 0.1, 0.2, 0.5, 1, and 2,
        //   ако постъпи различна да се отпечата "Cannot accept {money}", стойноста до вторият знак
        //   и да не се добавя към общата сума.
        //4. До команда End да се четат продукти. Продуктите са:
        //   "Nuts" - price: 2.0,
        //   "Water" - price: 0.7,
        //   "Crisps" - price: 1.5,
        //   "Soda" - price: 0.8,
        //   "Coke" - price: 1.0
        //5. Ако се въведе несъществуващ продукт да се отпечата: “Invalid product”
        //6. Да се следи дали парите са достатъчни за покупка, в противен случай: "Sorry, not enough money"
        //7. При успешна покупка: "Purchased {product name}"
        //8. След команда End, да се принтира рестото: "Change: {money left}".

        String input = scanner.nextLine();
        double totalSum = 0;
        double price = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                totalSum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            boolean isValid = true;
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    isValid = false;
                    break;
            }
            if (!isValid) {
                input = scanner.nextLine();
                continue;
            }
            if (price > totalSum) {
                System.out.println("Sorry, not enough money");
                input = scanner.nextLine();
                continue;
            }
            System.out.printf("Purchased %s%n", input);
            totalSum -= price;

            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalSum);
    }
}