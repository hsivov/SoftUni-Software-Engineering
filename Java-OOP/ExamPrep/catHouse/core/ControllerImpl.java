package ExamPrep.catHouse.core;

import ExamPrep.catHouse.common.ConstantMessages;
import ExamPrep.catHouse.entities.cat.Cat;
import ExamPrep.catHouse.entities.cat.LonghairCat;
import ExamPrep.catHouse.entities.cat.ShorthairCat;
import ExamPrep.catHouse.entities.houses.House;
import ExamPrep.catHouse.entities.houses.LongHouse;
import ExamPrep.catHouse.entities.houses.ShortHouse;
import ExamPrep.catHouse.entities.toys.Ball;
import ExamPrep.catHouse.entities.toys.Mouse;
import ExamPrep.catHouse.entities.toys.Toy;
import ExamPrep.catHouse.repositories.Repository;
import ExamPrep.catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static ExamPrep.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private Repository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.put(name, house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {

        Toy toy;

        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            String exMessage = String.format(NO_TOY_FOUND, toyType);
            throw  new IllegalArgumentException(exMessage);
        }

        houses.get(houseName).buyToy(toy);
        toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat;

        if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        if (catType.equals("LonghairCat") && houses.get(houseName).getClass().getSimpleName().equals("LongHouse")){
            houses.get(houseName).addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else if (catType.equals("ShorthairCat") && houses.get(houseName).getClass().getSimpleName().equals("ShortHouse")) {
            houses.get(houseName).addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return String.format(ConstantMessages.UNSUITABLE_HOUSE);
        }
    }

    @Override
    public String feedingCat(String houseName) {
        houses.get(houseName).feeding();

        return String.format(ConstantMessages.FEEDING_CAT, houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {

        double sumCatsPrice = houses.get(houseName).getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumToysPrice = houses.get(houseName).getToys().stream().mapToDouble(Toy::getPrice).sum();

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sumCatsPrice + sumToysPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        for (House house : houses.values()) {
            out.append(house.getStatistics())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
