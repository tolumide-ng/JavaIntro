package objectsDemo;

public class Rectangle {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Rectangle() {
        this.origin = new Point(0, 0);
    }

    public Rectangle(Point p) {
        this.origin = p;
    }

    public Rectangle(int w, int h) {
        this.origin = new Point(0, 0);
        this.width = w;
        this.height = h;
    }

    public Rectangle(Point p, int w, int h) {
        this.origin = p;
        this.width = w;
        this.height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing thr area of the rectangle
    public int getArea() {
        return this.width * this.height;
    }
}
