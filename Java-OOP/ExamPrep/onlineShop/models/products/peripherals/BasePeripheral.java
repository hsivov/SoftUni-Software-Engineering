package ExamPrep.onlineShop.models.products.peripherals;

import ExamPrep.onlineShop.common.constants.OutputMessages;
import ExamPrep.onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {

    private String connectionType;
    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + OutputMessages.PERIPHERAL_TO_STRING, getConnectionType());
    }
}
