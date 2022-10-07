package DefiningClasses.Exercise.CatLady;

public class Siamese extends Cat{

    private double earSize;

    public Siamese(String name, Double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", getName(), earSize);
    }
}
