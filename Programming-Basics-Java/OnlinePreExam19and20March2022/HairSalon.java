package OnlinePreExam19and20March2022;

import java.util.Scanner;

public class HairSalon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());
        int earnedMoney = 0;
        boolean isTargetReached = false;

        String activity = scanner.nextLine();

        while (!activity.equals("closed")){
            String type = scanner.nextLine();

            switch (activity){
                case "haircut":
                    switch (type){
                        case "mens":
                            earnedMoney += 15;
                            break;
                        case "ladies":
                            earnedMoney += 20;
                            break;
                        case "kids":
                            earnedMoney += 10;
                            break;
                    }
                    break;
                case "color":
                    switch (type){
                        case "touch up":
                            earnedMoney += 20;
                            break;
                        case "full color":
                            earnedMoney += 30;
                            break;
                    }
                    break;
            }
            if (earnedMoney >= target){
                isTargetReached = true;
                break;
            }

            activity = scanner.nextLine();
        }

        if (isTargetReached){
            System.out.println("You have reached your target for the day!");
            System.out.printf("Earned money: %dlv.", earnedMoney);
        } else {
            System.out.printf("Target not reached! You need %dlv. more.%n", target - earnedMoney);
            System.out.printf("Earned money: %dlv.", earnedMoney);
        }
    }
}
