package Retake_18April2023.vehicleShop.repositories;

import Retake_18April2023.vehicleShop.models.worker.Worker;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkerRepository implements Repository<Worker>{
    private Map<String, Worker> workers;

    public WorkerRepository() {
        this.workers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers.values());
    }

    @Override
    public void add(Worker model) {
        workers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Worker model) {
        return workers.remove(model.getName()) != null;
    }

    @Override
    public Worker findByName(String name) {
        return workers.get(name);
    }
}
