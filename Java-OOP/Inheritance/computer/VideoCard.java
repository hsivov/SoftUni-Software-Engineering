package Inheritance.computer;

public class VideoCard extends Component{
    private final int VRAM;
    private final int busSpeed;

    public VideoCard(String model, double price, int VRAM, int busSpeed) {
        super("Video Card", model, price);
        this.VRAM = VRAM;
        this.busSpeed = busSpeed;
    }
}
