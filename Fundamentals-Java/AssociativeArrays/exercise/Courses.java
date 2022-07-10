package AssociativeArrays.exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end")){
            String course = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if (isCourseExist(coursesMap, course)){
                coursesMap.get(course).add(studentName);
            } else {
                coursesMap.put(course, new ArrayList<>());
                coursesMap.get(course).add(studentName);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String student : entry.getValue()){
                System.out.printf("-- %s%n", student);
            }
        }

    }

    private static boolean isCourseExist(Map<String, List<String>> coursesMap, String course) {
        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            if (entry.getKey().equals(course)){
                return true;
            }
        }
        return false;
    }
}
