package MidExams;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int totalLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int bestStudentAttendances = 0;

        for (int student = 1; student <= numberOfStudents; student++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            //    {total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
            double totalBonus = studentAttendances * 1.00 / totalLectures * (5 + additionalBonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                bestStudentAttendances = studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", bestStudentAttendances);
    }
}
