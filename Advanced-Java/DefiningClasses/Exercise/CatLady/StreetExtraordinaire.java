package DefiningClasses.Exercise.CatLady;

public class StreetExtraordinaire extends Cat{
    private double decibels;

    public StreetExtraordinaire(String name, Double decibels) {
        super(name);
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), decibels);
    }
}
