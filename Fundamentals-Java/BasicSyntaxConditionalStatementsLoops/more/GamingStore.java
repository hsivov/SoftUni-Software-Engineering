package BasicSyntaxConditionalStatementsLoops.more;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        double price = 0;
        double spent = 0;
        boolean outOfMoney = false;

        String game = scanner.nextLine();
        while (!game.equals("Game Time")){
            boolean isValidGameTitle = true;
            switch (game){
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                case "OutFall 4":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    isValidGameTitle = false;
                    break;
            }
            if (!isValidGameTitle){
                game = scanner.nextLine();
                continue;
            }
            if (price > money){
                System.out.println("Too Expensive");
                game = scanner.nextLine();
                continue;
            }
            System.out.printf("Bought %s%n", game);
            money -= price;
            spent += price;

            if (money <= 0){
                System.out.println("Out of money!");
                outOfMoney = true;
                break;
            }

            game = scanner.nextLine();
        }
        if (!outOfMoney){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, money);
        }
    }
}
