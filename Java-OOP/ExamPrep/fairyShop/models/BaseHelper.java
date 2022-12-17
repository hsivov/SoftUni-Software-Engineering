package ExamPrep.fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPrep.fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper{

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        energy -= 10;

        if (energy < 0) {
            energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return getEnergy() > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        long countNotBrokenInstruments = getInstruments().stream().filter(instrument -> !instrument.isBroken()).count();

        out.append(String.format("Name: %s", name)).append(System.lineSeparator())
                .append(String.format("Energy: %s", energy)).append(System.lineSeparator())
                .append(String.format("Instruments: %d not broken left", countNotBrokenInstruments));
        return out.toString();
    }
}
