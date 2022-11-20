package ReflectionAndAnnotation.barracksWars;

import ReflectionAndAnnotation.barracksWars.core.Engine;
import ReflectionAndAnnotation.barracksWars.core.commands.CommandInterpreterImpl;
import ReflectionAndAnnotation.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.barracksWars.data.UnitRepository;
import ReflectionAndAnnotation.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
