package Retake_18April2023.vehicleShop.models.shop;

import Retake_18April2023.vehicleShop.models.tool.Tool;
import Retake_18April2023.vehicleShop.models.vehicle.Vehicle;
import Retake_18April2023.vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {

        Collection<Tool> tools = worker.getTools();

        for (Tool tool : tools) {
            while (!tool.isUnfit()) {
                vehicle.making();
                worker.working();
                tool.decreasesPower();

                if (vehicle.reached()) {
                    return;
                }

                if (!worker.canWork()) {
                    return;
                }
            }
        }
    }
}
