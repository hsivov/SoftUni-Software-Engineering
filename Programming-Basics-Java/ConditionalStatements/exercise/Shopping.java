package ConditionalStatements.exercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int gpu = Integer.parseInt(scanner.nextLine());
        int cpu = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double gpuTotal = gpu * 250;
        double cpuPrice = gpuTotal*0.35;
        double ramPrice = gpuTotal*0.1;

        double total = gpuTotal + cpu*cpuPrice + ram*ramPrice;

        if (gpu > cpu){
            total = total - total*0.15;
        }

        if (total <= budget){
            System.out.printf("You have %.2f leva left!",budget - total);
        }else{
            System.out.printf("Not enough money! You need %.2f leva more!",total - budget);
        }
    }
}
