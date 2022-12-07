package designPatterns.factory.cake;

public abstract class Cake implements CakeInterface {
    private double diameter;
    private double price;
    private int pieces;

    public Cake(double diameter, double price, int pieces) {
        this.diameter = diameter;
        this.price = price;
        this.pieces = pieces;
    }
}
