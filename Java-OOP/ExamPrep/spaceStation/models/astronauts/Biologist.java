package ExamPrep.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    private static final double INITIAL_UNITS_OF_OXYGEN = 70;
    public Biologist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        super.setOxygen(getOxygen() - 5);
    }
}
