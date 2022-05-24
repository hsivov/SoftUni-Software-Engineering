package OnlineExam18and19July2020;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bestPlayer = "";
        int maxGoals = 0;
        boolean hatTrick = false;
        String name = scanner.nextLine();

        while (!name.equals("END")){
            int goals = Integer.parseInt(scanner.nextLine());
            if (goals > maxGoals){
                bestPlayer = name;
                maxGoals = goals;
                if (maxGoals >= 3 && maxGoals < 10){
                    hatTrick = true;
                }else if(maxGoals >= 10){
                    hatTrick = true;
                    break;
                }
            }
            name = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);
        if (hatTrick){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoals);
        }else{
            System.out.printf("He has scored %d goals.", maxGoals);
        }
    }
}
