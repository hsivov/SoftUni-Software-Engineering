package ObjectsAndClasses.more.ComputerShop;

public class Computer {
    Processor processor;
    RAM ram;
    GPU gpu;
    Storage storage;

    Computer(Processor processor, RAM ram, GPU gpu, Storage storage){
        this.processor = processor;
        this.ram = ram;
        this.gpu = gpu;
        this.storage = storage;
    }

    public Processor getProcessor() {
        return processor;
    }

    public RAM getRam() {
        return ram;
    }

    public GPU getGpu() {
        return gpu;
    }

    public Storage getStorage() {
        return storage;
    }
}

class Processor {
    String model;
    int price;

    Processor(String model, int price){
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}

class RAM {
    String capacity;
    int price;

    RAM(String capacity, int price){
        this.capacity = capacity;
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}

class GPU {
    String model;
    int price;

    GPU(String model, int price){
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}

class Storage {
    String model;
    int price;

    Storage(String model, int price){
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}