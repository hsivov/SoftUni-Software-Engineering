package WhileLoop.exercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGradesLimit = Integer.parseInt(scanner.nextLine());
        int poorGrades = 0;
        double sumGrades = 0;
        int numberOfProblems = 0;
        String lastProblem = "";

        while (poorGrades < poorGradesLimit) {
            String inputName = scanner.nextLine();

            if (inputName.equals("Enough")) {
                break;
            }

            double grade = Double.parseDouble(scanner.nextLine());
            if (grade <= 4) {
                poorGrades++;
            }
            sumGrades += grade;
            numberOfProblems++;
            lastProblem = inputName;
        }

        double averageScore = sumGrades / numberOfProblems;
        if (poorGrades < poorGradesLimit) {
            System.out.printf("Average score: %.2f%n", averageScore);
            System.out.printf("Number of problems: %d%n", numberOfProblems);
            System.out.printf("Last problem: %s", lastProblem);
        }else{
            System.out.printf("You need a break, %d poor grades.", poorGrades);
        }
    }
}
