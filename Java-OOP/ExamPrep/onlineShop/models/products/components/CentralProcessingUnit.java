package ExamPrep.onlineShop.models.products.components;

public class CentralProcessingUnit extends BaseComponent{

    private static final double OVERALL_PERFORMANCE_MULTIPLAYER = 1.25;
    public CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE_MULTIPLAYER, generation);
    }
}
