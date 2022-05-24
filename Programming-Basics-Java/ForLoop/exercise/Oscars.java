package ForLoop.exercise;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int jury = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < jury; i++) {
            String juryMember = scanner.nextLine();
            double points = Double.parseDouble(scanner.nextLine());
            int lengthPoints = juryMember.length();
            double juryMemberPoints = (lengthPoints * points) / 2;
            academyPoints += juryMemberPoints;

            if (academyPoints > 1250.5){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", name, academyPoints);
                break;
            }else if(i == jury - 1) {
                System.out.printf("Sorry, %s you need %.1f more!", name, 1250.5 - academyPoints);
            }
        }
    }
}
