package WhileLoop.more;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottlesDetergent = Integer.parseInt(scanner.nextLine());
        int load = 1;
        int totalDetergent = bottlesDetergent * 750;
        int countDishes = 0;
        int countPots = 0;
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            if (load % 3 != 0) {
                int dishes = Integer.parseInt(input);
                int detergent = dishes * 5;
                totalDetergent -= detergent;
                countDishes += dishes;
            } else {
                int pots = Integer.parseInt(input);
                int detergent = pots * 15;
                totalDetergent -= detergent;
                countPots += pots;
            }

            if (totalDetergent < 0) {
                break;
            }
            load++;
            input = scanner.nextLine();
        }

        if (totalDetergent >= 0) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%nLeftover detergent %d ml.", countDishes, countPots, totalDetergent);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(totalDetergent));
        }
    }
}
