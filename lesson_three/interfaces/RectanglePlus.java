package interfaces;

import objectsDemo.Point;

public class RectanglePlus implements Relatable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    public RectanglePlus() {
        this.origin = new Point(0, 0);
    }

    public RectanglePlus(Point p) {
        this.origin = p;
    }

    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        this.width = w;
        this.height = h;
    }

    public RectanglePlus(Point p, int h, int w) {
        this.origin = p;
        this.height = h;
        this.width = w;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        this.origin.x = x;
        this.origin.y = y;
    }

    // a method for computing the area of the rectangle
    public int getArea() {
        return this.width * this.height;
    }

    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus)other;
        if(this.getArea() > otherRect.getArea())
            return -1;
        else if (this.getArea() < otherRect.getArea())
            return 1;
        else
            return 0;
    }
}
