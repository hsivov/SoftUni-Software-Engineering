package WhileLoop.exercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        int totalSteps = 0;
        String input = scanner.nextLine();

        while (!input.equals("Going home")){
            int steps = Integer.parseInt(input);
            totalSteps += steps;

            if (totalSteps >= goal){
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;
        }
        if (totalSteps >= goal){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", totalSteps - goal);
        }else{
            System.out.printf("%d more steps to reach goal.", goal - totalSteps);
        }
    }
}
