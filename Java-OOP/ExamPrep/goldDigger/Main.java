package ExamPrep.goldDigger;

import ExamPrep.goldDigger.core.Controller;
import ExamPrep.goldDigger.core.ControllerImpl;
import ExamPrep.goldDigger.core.Engine;
import ExamPrep.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
