package ExamPrep.onlineShop.models.products.computers;

import ExamPrep.onlineShop.common.constants.ExceptionMessages;
import ExamPrep.onlineShop.common.constants.OutputMessages;
import ExamPrep.onlineShop.models.products.BaseProduct;
import ExamPrep.onlineShop.models.products.Product;
import ExamPrep.onlineShop.models.products.components.Component;
import ExamPrep.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    private double componentsAverageOverallPerformance() {
        return components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0);
    }

    private double peripheralAverageOverallPerformance() {
        return peripherals.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0);
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }

        return super.getOverallPerformance() + componentsAverageOverallPerformance();
    }

    @Override
    public double getPrice() {
        return super.getPrice()
                + components.stream().mapToDouble(Product::getPrice).sum()
                + peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public void addComponent(Component component) {
        if (components.contains(component)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT, component.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if (component == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }

        components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream()
                .filter(c -> c.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL, peripheralType, getClass().getSimpleName(), getId()));
        }

        peripherals.remove(peripheral);

        return peripheral;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.PRODUCT_TO_STRING,
                        getOverallPerformance(),
                        getPrice(),
                        getClass().getSimpleName(),
                        getManufacturer(),
                        getModel(),
                        getId()))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, components.size())).append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ").append(component)
                    .append(System.lineSeparator());
        }

        sb.append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), peripheralAverageOverallPerformance()))
                .append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            sb.append("  ").append(peripheral)
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
