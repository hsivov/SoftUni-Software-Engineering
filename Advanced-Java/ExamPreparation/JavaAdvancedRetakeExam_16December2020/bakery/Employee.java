package ExamPreparation.JavaAdvancedRetakeExam_16December2020.bakery;

public class Employee {

    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.country = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", getName(), getAge(), getCountry());
    }
}
