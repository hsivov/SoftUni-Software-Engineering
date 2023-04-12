package ExamPrep.onlineShop;

import ExamPrep.onlineShop.core.EngineImpl;
import ExamPrep.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
