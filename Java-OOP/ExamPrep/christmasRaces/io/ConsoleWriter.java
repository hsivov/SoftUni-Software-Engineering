package ExamPrep.christmasRaces.io;

import ExamPrep.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
