package ExamPrep.goldDigger.models.discoverer;

import ExamPrep.goldDigger.common.ExceptionMessages;
import ExamPrep.goldDigger.models.museum.BaseMuseum;
import ExamPrep.goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer{

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }


    @Override
    public Museum getMuseum() {
        return museum;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public void dig() {
        this.energy -= 15;
        if (this.energy < 0){
            setEnergy(0);
        }
    }
}
