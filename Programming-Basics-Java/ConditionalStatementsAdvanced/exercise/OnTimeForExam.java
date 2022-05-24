package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int examTimeInMinutes = examHour * 60 + examMinutes;
        int arrivalTimeInMinutes = arrivalHour * 60 + arrivalMinutes;
        int diff = examTimeInMinutes - arrivalTimeInMinutes;

        int newHour = Math.abs(diff / 60);
        int newMin = Math.abs(diff % 60);

        if (diff >= 0 && diff <= 30) {
            System.out.println("On time");
            if (diff != 0) {
                System.out.printf("%d minutes before the start", diff);
            }
        } else if (diff > 30) {
            System.out.println("Early");
            if (newHour != 0) {
                System.out.printf("%d:%02d hours before the start", newHour, newMin);
            } else {
                System.out.printf("%d minutes before the start", newMin);
            }
        } else {
            System.out.println("Late");
            if (newHour != 0) {
                System.out.printf("%d:%02d hours after the start", newHour, newMin);
            }else{
                System.out.printf("%d minutes after the start", newMin);
            }
        }
    }
}
