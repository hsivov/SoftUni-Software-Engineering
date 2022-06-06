package Arrays.lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());

        String[] days = new String[] {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (day < 1 || day > 7){
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[day - 1]);
        }
    }
}
