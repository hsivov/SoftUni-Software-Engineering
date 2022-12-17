package ExamPrep.spaceStation.models.astronauts;

import ExamPrep.spaceStation.common.ConstantMessages;
import ExamPrep.spaceStation.common.ExceptionMessages;
import ExamPrep.spaceStation.models.bags.Backpack;
import ExamPrep.spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut{

    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public void breath() {
        oxygen -= 10;
        if (oxygen < 0) {
            oxygen = 0;
        }
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, name)).append(System.lineSeparator());
        out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, oxygen)).append(System.lineSeparator());

        String bag = getBag().getItems().isEmpty()
                ? "none"
                : String.join(", ", getBag().getItems());

        out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bag));

        return out.toString();
    }
}
