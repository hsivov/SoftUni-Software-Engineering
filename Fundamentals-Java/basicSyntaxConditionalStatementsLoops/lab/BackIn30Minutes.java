package basicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = hour * 60 + minutes;
        totalMinutes = totalMinutes + 30;

        int newMin = totalMinutes % 60;
        int newHour = totalMinutes / 60;
        if (newHour > 23){
            newHour = 0;
        }
        System.out.printf("%d:%02d", newHour, newMin);
    }
}
