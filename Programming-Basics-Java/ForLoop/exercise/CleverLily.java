package ForLoop.exercise;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double savedMoney = 0;
        int brother = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {
                //четни
            if (i % 2 == 0){
                double money = 10.0 * i/2;
                savedMoney += money;
                brother++;

                //нечетни
            }else{
                toys++;
            }
        }
        double totalMoney = savedMoney + toys*toyPrice - brother;

        if (totalMoney >= washingMachinePrice){
            System.out.printf("Yes! %.2f", totalMoney - washingMachinePrice);
        }else{
            System.out.printf("No! %.2f", washingMachinePrice - totalMoney);
        }
    }
}
