package ForLoop.more;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double top = 0;
        double good = 0;
        double average = 0;
        double fail = 0;

        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());

            total += grade;
            if (grade >= 5) {
                top++;
            } else if (grade >= 4) {
                good++;
            } else if (grade >= 3) {
                average++;
            } else {
                fail++;
            }
        }
        double averageGrade = total / students;
        double percentTop = top / students *100;
        double percentGood = good / students *100;
        double percentAverage = average / students *100;
        double percentFail = fail / students *100;
        System.out.printf("Top students: %.2f%%%n", percentTop);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentGood);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentAverage);
        System.out.printf("Fail: %.2f%%%n", percentFail);
        System.out.printf("Average: %.2f", averageGrade);
    }
}
