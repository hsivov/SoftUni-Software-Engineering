package Retake_18April2023.vehicleShop;

import Retake_18April2023.vehicleShop.core.Engine;
import Retake_18April2023.vehicleShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
