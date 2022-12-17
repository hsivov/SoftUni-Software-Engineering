package Exams.JavaAdvancedRetakeExam_17Dec2019.christmas;

public class Present {

    private String name;
    private double weight;
    private String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        //Present {name} ({weight}) for a {gender}"
        return String.format("Present %s (%.2f) for a %s", name, weight, gender);
    }
}
