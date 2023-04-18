package Retake_18April2023.vehicleShop.models.shop;

import Retake_18April2023.vehicleShop.models.vehicle.Vehicle;
import Retake_18April2023.vehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
