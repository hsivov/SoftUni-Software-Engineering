package FunctionalProgramming.Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPerson = sc -> {
            String[] data = sc.nextLine().split(", ");
            return new Person(data[0], Integer.parseInt(data[1]));
        };

        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = getFilter(condition, age);
        Consumer<Person> printer = getPrinter(format);

        people.stream()
                .filter(ageFilter)
                .forEach(printer);
    }

    private static Consumer<Person> getPrinter(String format) {

        switch (format) {
            case "name":
                return person -> System.out.println(person.name);
            case "age":
                return person -> System.out.println(person.age);
            case "name age":
                return person -> System.out.println(person.name + " - " + person.age);
            default:
                throw new IllegalArgumentException("Unknown print format " + format);
        }
    }

    private static Predicate<Person> getFilter(String condition, int age) {

        switch (condition) {
            case "older":
                return person -> person.age >= age;
            case "younger":
                return person -> person.age <= age;
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }
    }
}
