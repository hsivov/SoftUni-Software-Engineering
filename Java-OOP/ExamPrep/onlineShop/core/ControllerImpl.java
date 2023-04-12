package ExamPrep.onlineShop.core;

import ExamPrep.onlineShop.common.constants.ExceptionMessages;
import ExamPrep.onlineShop.core.interfaces.Controller;
import ExamPrep.onlineShop.models.products.Product;
import ExamPrep.onlineShop.models.products.components.*;
import ExamPrep.onlineShop.models.products.computers.Computer;
import ExamPrep.onlineShop.models.products.computers.DesktopComputer;
import ExamPrep.onlineShop.models.products.computers.Laptop;
import ExamPrep.onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ExamPrep.onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private List<Computer> computers;
    private List<Peripheral> peripherals;
    private List<Component> components;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.components = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        boolean isComputerExist = computers.stream().anyMatch(c -> c.getId() == id);

        if (isComputerExist) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }

        Computer computer;

        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        computers.add(computer);

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        boolean isPeripheralExist = peripherals.stream().anyMatch(peripheral -> peripheral.getId() == id);
        if (isPeripheralExist) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;
        if (peripheralType.equals("Headset")) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Keyboard")) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Monitor")) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Mouse")) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        peripherals.add(peripheral);
        computer.addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        computer.removePeripheral(peripheralType);

        Peripheral peripheral = peripherals.stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElseThrow();

        peripherals.remove(peripheral);

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        boolean isComponentExist = components.stream().anyMatch(component -> component.getId() == id);
        if (isComponentExist) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }

        Component component;
        if (componentType.equals("CentralProcessingUnit")) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("Motherboard")) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("PowerSupply")) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("RandomAccessMemory")) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("SolidStateDrive")) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("VideoCard")) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        components.add(component);
        computer.addComponent(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computerById = computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computerById == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        computerById.removeComponent(componentType);

        Component currentComponent = components.stream()
                .filter(component -> component.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElseThrow();

        components.remove(currentComponent);

        return String.format(REMOVED_COMPONENT, componentType, currentComponent.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer toRemove = computers.stream().filter(computer -> computer.getId() == id).findFirst().orElse(null);

        if (toRemove == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        String removed = toRemove.toString();
        computers.remove(toRemove);

        return removed;
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer bestBuy = computers.stream()
                .filter(computer -> computer.getPrice() <= budget)
                .max(Comparator.comparingDouble(Product::getOverallPerformance))
                .orElse(null);

        if (bestBuy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        String removed = bestBuy.toString();
        computers.remove(bestBuy);

        return removed;
    }

    @Override
    public String getComputerData(int id) {
        Computer currentComputer = computers.stream().filter(computer -> computer.getId() == id).findFirst().orElse(null);

        if (currentComputer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        return currentComputer.toString();
    }
}
