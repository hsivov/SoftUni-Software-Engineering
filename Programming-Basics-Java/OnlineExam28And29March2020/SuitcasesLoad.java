package OnlineExam28And29March2020;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String load = scanner.nextLine();
        int count = 0;
        boolean isMoreSpace = true;

        while (!load.equals("End")){
            double suitcase = Double.parseDouble(load);
            count++;
            if (count % 3 == 0){
                suitcase = suitcase * 1.10;
            }
            if (capacity < suitcase){
                isMoreSpace = false;
                System.out.println("No more space!");
                count -= 1;
                break;
            }
            capacity -= suitcase;
            load = scanner.nextLine();
        }
        if (isMoreSpace) {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", count);
    }
}
