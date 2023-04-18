package Retake_18April2023.vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    private static final int INITIAL_STRENGTH = 70;
    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {
        super.working();
        setStrength(getStrength() - 5);
    }
}
