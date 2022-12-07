package designPatterns.builder;

public class Person {

    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder withFirstName(String name) {
            person.firstName = name;
            return this;
        }

        public Builder withLastName(String name) {
            person.lastName = name;
            return this;
        }

        public Builder withEmail(String email) {
            person.email = email;
            return this;
        }

        public Person build() {
            validate();
            return person;
        }

        public void validate() {
            StringBuilder exMessage = new StringBuilder();

            if (person.firstName.isEmpty()) {
                exMessage.append("First name is empty.");
            }
            if (person.lastName.isEmpty()) {
                exMessage.append("Last name is empty.");
            }
            if (person.email.isEmpty()) {
                exMessage.append("Email is empty.");
            }

            if (exMessage.length() > 1) {
                throw new NullPointerException(exMessage.toString());
            }
        }
    }
}
