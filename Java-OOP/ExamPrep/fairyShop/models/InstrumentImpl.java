package ExamPrep.fairyShop.models;

import static ExamPrep.fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        power -= 10;

        if (power < 0) {
            power = 0;
        }
    }

    @Override
    public boolean isBroken() {
        return power == 0;
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}
