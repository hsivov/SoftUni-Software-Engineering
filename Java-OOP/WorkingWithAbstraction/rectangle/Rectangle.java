package WorkingWithAbstraction.rectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point) {
        boolean isInsideX = point.getX() >= getBottomLeft().getX() && point.getX() <= getTopRight().getX();
        boolean isInsideY = point.getY() >= getBottomLeft().getY() && point.getY() <= getTopRight().getY();

        return isInsideX && isInsideY;
    }
}
