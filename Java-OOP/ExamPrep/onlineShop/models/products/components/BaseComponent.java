package ExamPrep.onlineShop.models.products.components;

import ExamPrep.onlineShop.common.constants.OutputMessages;
import ExamPrep.onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component{

    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(OutputMessages.COMPONENT_TO_STRING, getGeneration());
    }
}
