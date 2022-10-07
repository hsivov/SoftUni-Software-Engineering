package DefiningClasses.Exercise.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        int numberOfPersons = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPersons; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            personList.add(person);
        }
        personList.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
