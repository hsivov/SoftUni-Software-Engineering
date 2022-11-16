package solid.output;

public class Printer implements Output{

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";


    @Override
    public void printSum(double sum) {
        System.out.printf((SUM) + "%n", sum);
    }

    @Override
    public void printAverage(double average) {
        System.out.printf((AVERAGE) + "%n", average);
    }
}
