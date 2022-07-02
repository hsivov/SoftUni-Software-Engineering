package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static class Person{
        String name;
        String id;
        int age;

        Person (String name, String id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String consoleLine = scanner.nextLine();
        while (!consoleLine.equals("End")){
            String name = consoleLine.split(" ")[0];
            String id = consoleLine.split(" ")[1];
            int age = Integer.parseInt(consoleLine.split(" ")[2]);

            Person person = new Person(name, id, age);
            personList.add(person);

            consoleLine = scanner.nextLine();
        }
        personList.sort(Comparator.comparingInt(Person::getAge));

        for (Person person : personList){
            System.out.println(person);
        }
    }
}
