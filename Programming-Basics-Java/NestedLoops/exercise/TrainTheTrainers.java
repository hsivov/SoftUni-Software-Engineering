package NestedLoops.exercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        int count = 0;
        double averageGradeAll = 0;

        while (!presentation.equals("Finish")){

            double gradesSum = 0;

            for (int i = 0; i < n; i++) {
                count++;
                double grade = Double.parseDouble(scanner.nextLine());
                gradesSum += grade;
            }

            System.out.printf("%s - %.2f.%n", presentation, gradesSum / n);
            averageGradeAll += gradesSum;
            presentation = scanner.nextLine();
        }
        averageGradeAll = averageGradeAll / count;
        System.out.printf("Student's final assessment is %.2f.", averageGradeAll);
    }
}
