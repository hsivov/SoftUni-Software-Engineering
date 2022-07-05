package ObjectsAndClasses.more.CarSalesman;

public class Car {
    String model;
    Engine engine;
    String weight;
    String color;

    public static class Engine {
        String model;
        String power;
        String displacement;
        String efficiency;

        Engine(String model, String power, String displacement, String efficiency){
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }
    }
}
