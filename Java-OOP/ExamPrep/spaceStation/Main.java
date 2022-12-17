package ExamPrep.spaceStation;

import ExamPrep.spaceStation.core.Controller;
import ExamPrep.spaceStation.core.ControllerImpl;
import ExamPrep.spaceStation.core.Engine;
import ExamPrep.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);

        engine.run();
    }
}
