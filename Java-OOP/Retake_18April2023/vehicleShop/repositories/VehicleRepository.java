package Retake_18April2023.vehicleShop.repositories;

import Retake_18April2023.vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleRepository implements Repository<Vehicle> {
    private Map<String, Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new LinkedHashMap<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles.values());
    }

    @Override
    public void add(Vehicle model) {
        vehicles.put(model.getName(), model);
    }

    @Override
    public boolean remove(Vehicle model) {
        return vehicles.remove(model.getName()) != null;
    }

    @Override
    public Vehicle findByName(String name) {
        return vehicles.get(name);
    }
}
