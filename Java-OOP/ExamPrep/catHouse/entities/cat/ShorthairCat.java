package ExamPrep.catHouse.entities.cat;

public class ShorthairCat extends BaseCat{

    private static final int INITIAL_KILOGRAMS = 7;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }

}
