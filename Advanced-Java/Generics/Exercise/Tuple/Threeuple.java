package Generics.Exercise.Tuple;

public class Threeuple<F, S, T> extends Tuple<F, S> {

    private T third;

    public Threeuple(F first, S second, T third) {
        super(first, second);
        setThird(third);
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", getFirst(), getSecond(), getThird());
    }
}
