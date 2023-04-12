package ExamPrep.viceCity;

import ExamPrep.viceCity.core.ControllerImpl;
import ExamPrep.viceCity.core.EngineImpl;
import ExamPrep.viceCity.core.interfaces.Controller;
import ExamPrep.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
