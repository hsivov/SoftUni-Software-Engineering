package Inheritance.computer;

public class RAM extends Component{

    private final int capacity;

    public RAM(String model, double price, int capacity) {
        super("RAM", model, price);
        this.capacity = capacity;
    }
}
