package DefiningClasses.Exercise.Google;

import java.util.List;

public class Person {

    private Company company;
    private Car car;
    private List<Children> children;
    private List<Parents> parent;
    private List<Pokemon> pokemon;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Parents> getParent() {
        return parent;
    }

    public void setParent(List<Parents> parent) {
        this.parent = parent;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    static class Company{
        private final String companyName;
        private final String department;
        private final double salary;

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Company:%n%s %s %.2f", companyName, department, salary);
        }
    }

    static class Car{
        private final String carModel;
        private final int carSpeed;

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        @Override
        public String toString() {
            return String.format("Car:%n%s %d", carModel, carSpeed);
        }
    }

    static class Children {
        private final String childName;
        private final String childBirthday;

        public Children(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }
        @Override
        public String toString() {
            return String.format("%s %s", childName, childBirthday);
        }
    }

    static class Parents {
        private final String parentName;
        private final String parentBirthday;

        public Parents(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }
        @Override
        public String toString() {
            return String.format("%s %s", parentName, parentBirthday);
        }
    }

    static class Pokemon {
        private final String pokemonName;
        private final String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }
        @Override
        public String toString() {
            return String.format("%s %s", pokemonName, pokemonType);
        }
    }
}
