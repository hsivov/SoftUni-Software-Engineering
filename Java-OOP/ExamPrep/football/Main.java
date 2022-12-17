package ExamPrep.football;

import ExamPrep.football.core.Engine;
import ExamPrep.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
