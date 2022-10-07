package DefiningClasses.Exercise.CarSalesman;

public class Car {
    String model;
    Engine engine;
    String weight;
    String color;

    Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

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

        public String getModel() {
            return model;
        }

        public String getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }
    public String toString() {
        return String.format("%s:%n  %s:%n    Power: %s%n    Displacement: %s%n" +
                "    Efficiency: %s%n  Weight: %s%n  Color: %s", this.model, this.engine.getModel(), this.engine.getPower(),
                this.engine.getDisplacement(), this.engine.getEfficiency(), this.weight, this.color);
    }
}
