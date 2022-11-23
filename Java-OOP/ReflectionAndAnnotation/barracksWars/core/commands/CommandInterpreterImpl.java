package ReflectionAndAnnotation.barracksWars.core.commands;

import ReflectionAndAnnotation.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotation.barracksWars.interfaces.Executable;
import ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotation.barracksWars.annotations.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable command;
        String className = parseCommandToClassName(commandName);
        try {
            Class clazz = Class.forName(className);
            Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class);
            command = constructor.newInstance(new Object[]{data});
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    if (field.getType().equals(Repository.class)) {
                        field.setAccessible(true);
                        field.set(command, repository);
                    } else if (field.getType().equals(UnitFactory.class)) {
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException("Invalid command!");
        }
        return command;
    }

    private static String parseCommandToClassName(String commandName) {
        String commandNameFirstUpper = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        return UNITS_PACKAGE_NAME + commandNameFirstUpper + "Command";
    }
}
