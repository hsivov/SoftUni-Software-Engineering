package ReflectionAndAnnotation.barracksWars.core.factories;

import ReflectionAndAnnotation.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {

		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
				 InstantiationException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
