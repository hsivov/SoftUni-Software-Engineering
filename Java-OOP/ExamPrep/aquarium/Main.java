package ExamPrep.aquarium;

import ExamPrep.aquarium.core.Engine;
import ExamPrep.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
