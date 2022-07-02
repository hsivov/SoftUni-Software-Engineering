package ObjectsAndClasses.exercise.Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Students> studentsList = new ArrayList<>();

        for (int line = 1; line <= n; line++) {
            String personalData = scanner.nextLine();
            String firstName = personalData.split(" ")[0];
            String lastName = personalData.split(" ")[1];
            double grade = Double.parseDouble(personalData.split(" ")[2]);

            Students student = new Students(firstName, lastName, grade);
            studentsList.add(student);
        }
        studentsList.sort(Comparator.comparingDouble(Students::getGrade)
                .reversed());

        //"{first name} {second name}: {grade}".
        for (Students student : studentsList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
