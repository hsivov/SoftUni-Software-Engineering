package OnlineExam28And29March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int sets = Integer.parseInt(scanner.nextLine());
        double price = 0;

//        1.	Плод - текст с възможности: "Watermelon", "Mango", "Pineapple" или "Raspberry"
//        2.	Размерът на сета - текст с възможности: "small" или "big"
//        3.	Брой на поръчаните сетове - цяло число в интервала [1 … 10000]


        switch (fruit) {
            case "Watermelon":
                if ("small".equals(size)) {
                    price = 2 * 56;
                } else if ("big".equals(size)) {
                    price = 5 * 28.70;
                }
                break;
            case "Mango":
                if ("small".equals(size)) {
                    price = 2 * 36.66;
                } else if ("big".equals(size)) {
                    price = 5 * 19.60;
                }
                break;
            case "Pineapple":
                if ("small".equals(size)) {
                    price = 2 * 42.10;
                } else if ("big".equals(size)) {
                    price = 5 * 24.80;
                }
                break;
            case "Raspberry":
                if ("small".equals(size)) {
                    price = 2 * 20;
                } else if ("big".equals(size)) {
                    price = 5 * 15.20;
                }
                break;
        }
        price = price * sets;

        if (price >= 400 && price <= 1000){
            price = price * 0.85;
        }else if(price > 1000){
            price = price * 0.5;
        }

        System.out.printf("%.2f lv.", price);
    }
}
