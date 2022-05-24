package basicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesLost = Integer.parseInt(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double monitorPrice = Double.parseDouble(scanner.nextLine());

        int mouse = gamesLost / 2;
        int headsets = gamesLost / 3;
        int keyboards = gamesLost / 6;
        int monitors = gamesLost / 12;

        double total = mouse * mousePrice + headsets * headsetPrice + keyboards * keyboardPrice + monitors * monitorPrice;

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
