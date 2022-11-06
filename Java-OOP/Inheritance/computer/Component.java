package Inheritance.computer;

public class Component {
    private final String name;
    private final String model;
    private final double price;

    public Component(String name, String model, double price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return System.lineSeparator() +
                name + " - " + model + ", price: " + price;
    }
}
