package ExamPrep.onlineShop.models.products.components;

public class PowerSupply extends BaseComponent{

    private static final double OVERALL_PERFORMANCE_MULTIPLAYER = 1.05;
    public PowerSupply(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE_MULTIPLAYER, generation);
    }
}
