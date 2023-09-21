package classes;

public class Movement {
    Movement(Circle myCircle) {
        this.moveCircle(myCircle, 23, 56);
    }

    public void moveCircle(Circle circle, int deltaX, int deltaY) {
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        circle = new Circle(0, 0);
    }
}
