package ExamPrep.fairyShop;

import ExamPrep.fairyShop.core.Engine;
import ExamPrep.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
