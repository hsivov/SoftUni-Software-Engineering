package designPatterns.factory;

import designPatterns.factory.cake.*;

public class CakeFactory {

    public static Cake createCake(String cakeType, double diameter, double price, int pieces) {

        Cake cake;
        switch (cakeType) {
            case "Choco":
                cake = new ChocolateCake(diameter, price, pieces);
                break;
            case "Fruit":
                cake = new FruitCake(diameter, price, pieces);
                break;
            case "SoftUni":
                cake = new SoftUniCake(diameter, price, pieces);
                break;
            case "Spinach":
                cake = new SpinachCake(diameter, price, pieces);
                break;
            default:
                throw new NullPointerException("Invalid type.");
        }
        return cake;
    }

}
