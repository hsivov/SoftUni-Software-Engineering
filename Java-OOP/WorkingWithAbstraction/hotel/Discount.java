package WorkingWithAbstraction.hotel;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);
    private double percent;

    Discount(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
