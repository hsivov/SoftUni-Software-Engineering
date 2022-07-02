package ObjectsAndClasses.exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int line = 1; line <= n; line++) {
            String personData = scanner.nextLine();
            String name = personData.split(" ")[0];
            int age = Integer.parseInt(personData.split(" ")[1]);

            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            personList.add(person);
        }

        for (Person member : personList) {
            if (member.getAge() > 30) {
                System.out.println(member);
            }
        }
    }
}
