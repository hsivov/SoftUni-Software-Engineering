package garage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTest {

    private Garage garage;
    private Car car;

    private List<Car> cars;

    @Before
    public void setUp() {
        garage = new Garage();
        car = new Car("Lamborghini", 300, 4690000);
        cars = List.of(new Car("Ford", 240, 250000),
                new Car("Ferrari", 325, 550000),
                new Car("Dodge", 235, 320000));
    }

    @Test
    public void testAddCarShouldAddToCarList() {
        int countBeforeAdd = garage.getCount();
        garage.addCar(car);
        assertEquals(countBeforeAdd + 1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowWhenCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testGetCarsShouldReturnListOfCar() {
        cars.forEach(garage::addCar);
        assertEquals(cars, garage.getCars());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        cars.forEach(garage::addCar);
        List<Car> fastCars = garage.findAllCarsWithMaxSpeedAbove(300);

        assertEquals(1, fastCars.size());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        cars.forEach(garage::addCar);
        car = garage.getTheMostExpensiveCar();

        assertEquals("Ferrari", car.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand() {
        cars.forEach(garage::addCar);

        List<Car> allCarsByBrand = garage.findAllCarsByBrand("Dodge");
        assertEquals(1, allCarsByBrand.size());
    }
}