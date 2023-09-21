package classes;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Polygon {}


public class Shape {
    public Polygon polygonFrom1(Point[] corners) {
        return new Polygon();
    }

    public Polygon polyFrom(Point... corners) {
        int numberOfSides = corners.length;
        double squareOfSide1, lengthOfSide1;
        squareOfSide1 = (corners[1].x - corners[0].x) 
            * (corners[1].x - corners[0].x)
            + (corners[1].y - corners[0].y)
            * (corners[1].y - corners[0].y);


        lengthOfSide1 = Math.sqrt(squareOfSide1);
    }
}
