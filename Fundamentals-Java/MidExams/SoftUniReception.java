package MidExams;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capabilityEmployee1 = Integer.parseInt(scanner.nextLine());
        int capabilityEmployee2 = Integer.parseInt(scanner.nextLine());
        int capabilityEmployee3 = Integer.parseInt(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        int allEmployeeCapabilityForHour = capabilityEmployee1 + capabilityEmployee2 + capabilityEmployee3;
        int hourCount = 0;

        while (numberOfStudents > 0){
            hourCount++;
            if (hourCount % 4 != 0 || hourCount == 0) {
                numberOfStudents -= allEmployeeCapabilityForHour;
            }
        }
        System.out.printf("Time needed: %dh.", hourCount);
    }
}
