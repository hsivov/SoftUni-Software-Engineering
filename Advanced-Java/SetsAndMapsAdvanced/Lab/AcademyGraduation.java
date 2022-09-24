package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsMap = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();


            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());


            double averageGrade = 0;
            for (Double grade : grades) {
                averageGrade += grade;
            }
            averageGrade = averageGrade / grades.size();

            studentsMap.putIfAbsent(name, averageGrade);
        }

        for (Map.Entry<String, Double> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }

    }
}
