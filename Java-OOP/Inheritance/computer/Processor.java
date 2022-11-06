package Inheritance.computer;

public class Processor extends Component{

    private final String frequency;

    public Processor(String model, double price, String frequency) {
        super("Processor", model, price);
        this.frequency = frequency;
    }
}
