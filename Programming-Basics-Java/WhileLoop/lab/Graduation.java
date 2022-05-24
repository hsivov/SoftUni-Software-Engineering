package WhileLoop.lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int years = 12;
        int passedYears = 0;
        int failedYears = 0;
        double sumGrades = 0;
        boolean isGraduated = true;

        while (passedYears < years) {

            if (failedYears > 1){
                isGraduated = false;
                break;
            }

            double grade = Double.parseDouble(scanner.nextLine());

            if (grade < 4) {
                failedYears++;
            } else {
                passedYears++;
                sumGrades += grade;
                failedYears = 0;
            }
        }
        double averageGrade = sumGrades / years;

        if (isGraduated){
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }else{
            System.out.printf("%s has been excluded at %d grade", name, passedYears + 1);
        }
    }
}
