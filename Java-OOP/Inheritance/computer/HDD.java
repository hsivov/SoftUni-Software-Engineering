package Inheritance.computer;

public class HDD extends Component{

    private final int capacity;

    private final String type;

    public HDD(String model, double price, int capacity, String type) {
        super("Hard Drive", model, price);
        this.capacity = capacity;
        this.type = type;
    }
}
