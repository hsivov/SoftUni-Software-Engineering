package ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] data = input.split("_");
            String methodName = data[0];
            int argument = Integer.parseInt(data[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, argument);

            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
