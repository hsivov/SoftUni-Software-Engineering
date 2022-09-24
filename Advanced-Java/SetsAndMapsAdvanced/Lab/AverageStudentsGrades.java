package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentRecord = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            double grade = Double.parseDouble(input.split(" ")[1]);

            studentRecord.putIfAbsent(name, new ArrayList<>());

            List<Double> grades = studentRecord.get(name);
            grades.add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : studentRecord.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double average = 0;
            for (Double grade : entry.getValue()) {
                average += grade;
                System.out.printf("%.2f ", grade);
            }
            average = average / entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", average);
        }

    }
}
