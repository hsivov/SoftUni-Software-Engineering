package ExamPrep.spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    private static final double INITIAL_UNITS_OF_OXYGEN = 50;
    public Geodesist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }
}
