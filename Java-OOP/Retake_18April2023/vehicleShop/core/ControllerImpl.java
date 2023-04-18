package Retake_18April2023.vehicleShop.core;

import Retake_18April2023.vehicleShop.common.ConstantMessages;
import Retake_18April2023.vehicleShop.common.ExceptionMessages;
import Retake_18April2023.vehicleShop.models.shop.ShopImpl;
import Retake_18April2023.vehicleShop.models.tool.ToolImpl;
import Retake_18April2023.vehicleShop.models.vehicle.VehicleImpl;
import Retake_18April2023.vehicleShop.models.worker.FirstShift;
import Retake_18April2023.vehicleShop.models.worker.SecondShift;
import Retake_18April2023.vehicleShop.repositories.VehicleRepository;
import Retake_18April2023.vehicleShop.repositories.WorkerRepository;
import Retake_18April2023.vehicleShop.models.shop.Shop;
import Retake_18April2023.vehicleShop.models.tool.Tool;
import Retake_18April2023.vehicleShop.models.vehicle.Vehicle;
import Retake_18April2023.vehicleShop.models.worker.Worker;
import Retake_18April2023.vehicleShop.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private Repository<Worker> workerRepository;
    private Repository<Vehicle> vehicleRepository;
    private int vehicleCount = 0;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        workerRepository.add(worker);
        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

        vehicleRepository.add(vehicle);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);
        Worker worker = workerRepository.findByName(workerName);

        if (worker == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        worker.addTool(tool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> suitableWorkers = workerRepository.getWorkers().stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        if (suitableWorkers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        Vehicle vehicle = vehicleRepository.findByName(vehicleName);
        Shop shop = new ShopImpl();

        long brokenToolsCount = 0;
        for (Worker suitableWorker : suitableWorkers) {

            shop.make(vehicle, suitableWorker);
            brokenToolsCount = suitableWorker.getTools().stream().filter(Tool::isUnfit).count();
            if (vehicle.reached()) {
                vehicleCount++;
                break;
            }
        }

        String output = vehicle.reached() ?
                "done" :
                "not done";

        return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, output) + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenToolsCount);
    }

    @Override
    public String statistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d vehicles are ready!", vehicleCount)).append(System.lineSeparator())
                .append("Info for workers:").append(System.lineSeparator());

        for (Worker worker : workerRepository.getWorkers()) {

            long toolsLeft = worker.getTools().stream().filter(tool -> !tool.isUnfit()).count();

            output.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength())).append(System.lineSeparator())
                    .append(String.format("Tools: %d fit left", toolsLeft)).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
