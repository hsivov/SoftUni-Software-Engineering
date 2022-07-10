package AssociativeArrays.exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(student)){
                studentsMap.put(student, new ArrayList<>());
                studentsMap.get(student).add(grade);
            } else {
                studentsMap.get(student).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double averageGrade = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().orElse(0.0);
            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}
