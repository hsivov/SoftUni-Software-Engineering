package basicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = studentsCount / 6;

        double equipmentPrice = lightsabersPrice * Math.ceil(studentsCount * 1.10) +
                                robesPrice * studentsCount + beltsPrice * (studentsCount - freeBelts);
        if (money >= equipmentPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", equipmentPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", equipmentPrice - money);
        }
    }
}
