package DefiningClasses.Exercise.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String section = input.split(" ")[1];

            switch (section) {
                case "company":
                    String companyName = input.split(" ")[2];
                    String department = input.split(" ")[3];
                    double salary = Double.parseDouble(input.split(" ")[4]);

                    Person.Company company = new Person.Company(companyName, department, salary);

                    personMap.putIfAbsent(name, new Person());
                    personMap.get(name).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = input.split(" ")[2];
                    String pokemonType = input.split(" ")[3];

                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);
                    if (!personMap.containsKey(name)) {
                        personMap.put(name, new Person());
                        personMap.get(name).setPokemon(new ArrayList<>());
                        personMap.get(name).getPokemon().add(pokemon);
                    } else {
                        if (personMap.get(name).getPokemon() != null) {
                            personMap.get(name).getPokemon().add(pokemon);
                        } else {
                            personMap.get(name).setPokemon(new ArrayList<>());
                            personMap.get(name).getPokemon().add(pokemon);
                        }
                    }
                    break;

                case "parents":
                    String parentName = input.split(" ")[2];
                    String parentBirthday = input.split(" ")[3];

                    Person.Parents parent = new Person.Parents(parentName, parentBirthday);
                    if (!personMap.containsKey(name)) {
                        personMap.put(name, new Person());
                        personMap.get(name).setParent(new ArrayList<>());
                        personMap.get(name).getParent().add(parent);
                    } else {
                        if (personMap.get(name).getParent() != null) {
                            personMap.get(name).getParent().add(parent);
                        } else {
                            personMap.get(name).setParent(new ArrayList<>());
                            personMap.get(name).getParent().add(parent);
                        }
                    }
                    break;

                case "children":
                    String childName = input.split(" ")[2];
                    String childBirthday = input.split(" ")[3];

                    Person.Children child = new Person.Children(childName, childBirthday);
                    if (!personMap.containsKey(name)) {
                        personMap.putIfAbsent(name, new Person());
                        personMap.get(name).setChildren(new ArrayList<>());
                        personMap.get(name).getChildren().add(child);
                    } else {
                        if (personMap.get(name).getChildren() != null) {
                            personMap.get(name).getChildren().add(child);
                        } else {
                            personMap.get(name).setChildren(new ArrayList<>());
                            personMap.get(name).getChildren().add(child);
                        }
                    }
                    break;

                case "car":
                    String carModel = input.split(" ")[2];
                    int carSpeed = Integer.parseInt(input.split(" ")[3]);

                    Person.Car car = new Person.Car(carModel, carSpeed);
                    personMap.putIfAbsent(name, new Person());
                    personMap.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();

        Person person = personMap.get(name);
        System.out.println(name);

        printObject(person.getCompany(), "Company:");
        printObject(person.getCar(), "Car:");


        printPokemon(person.getPokemon());
        printParents(person.getParent());
        printChildren(person.getChildren());
    }
    private static void printObject(Object object, String ifNull) {
        if (object != null) {
            System.out.println(object);
        } else {
            System.out.println(ifNull);
        }
    }

    private static void printParents(List<Person.Parents> parentsList) {
        if (parentsList != null) {
            System.out.println("Parents:");
            for (Person.Parents parent : parentsList) {
                System.out.println(parent);
            }
        } else {
            System.out.println("Parents:");
        }
    }

    private static void printPokemon(List<Person.Pokemon> pokemonList) {
        if (pokemonList != null) {
            System.out.println("Pokemon:");
            for (Person.Pokemon pokemon : pokemonList) {
                System.out.println(pokemon);
            }
        } else {
            System.out.println("Pokemon:");
        }
    }

    private static void printChildren(List<Person.Children> childrenList) {
        if (childrenList != null) {
            System.out.println("Children:");
            for (Person.Children child : childrenList) {
                System.out.println(child);
            }
        } else {
            System.out.println("Children:");
        }
    }
}

