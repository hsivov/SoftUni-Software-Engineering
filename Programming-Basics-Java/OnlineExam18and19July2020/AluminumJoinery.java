package OnlineExam18and19July2020;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfJoinery = Integer.parseInt(scanner.nextLine());
        String size = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;

        switch (size) {
            case "90X130":
                if (numberOfJoinery > 60) {
                    price = 110 * 0.92;
                } else if (numberOfJoinery > 30) {
                    price = 110 * 0.95;
                } else {
                    price = 110;
                }
                break;
            case "100X150":
                if (numberOfJoinery > 80) {
                    price = 140 * 0.90;
                } else if (numberOfJoinery > 40) {
                    price = 140 * 0.94;
                } else {
                    price = 140;
                }
                break;
            case "130X180":
                if (numberOfJoinery > 50) {
                    price = 190 * 0.88;
                } else if (numberOfJoinery > 20) {
                    price = 190 * 0.93;
                } else {
                    price = 190;
                }
                break;
            case "200X300":
                if (numberOfJoinery > 50) {
                    price = 250 * 0.86;
                } else if (numberOfJoinery > 25) {
                    price = 250 * 0.91;
                } else {
                    price = 250;
                }
                break;
        }
        if (!delivery.equals("With delivery")) {
            totalPrice = (price * numberOfJoinery);
        } else {
            totalPrice = (price * numberOfJoinery) + 60;
        }

        if (numberOfJoinery > 99) {
            totalPrice = totalPrice * 0.96;
        }
        if (numberOfJoinery < 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", totalPrice);
        }
    }
}
