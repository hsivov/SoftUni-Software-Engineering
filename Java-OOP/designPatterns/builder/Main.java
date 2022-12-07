package designPatterns.builder;

public class Main {
    public static void main(String[] args) {

        Person person = Person.builder()
                .withFirstName("Hristo")
                .withLastName("")
                .withEmail("h@abv.bg")
                .build();
    }
}
