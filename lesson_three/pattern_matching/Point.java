package pattern_matching;


class Point {
    private int x;
    private int y;

    public boolean equal(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        Point point = (Point) o;
        return this.x == point.x && this.y == point.y;
    }

    public boolean modifiedEqual(Object o) {
        return o instanceof Point point && this.x == point.x && this.y == point.y;
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String [] args) {
        Object objA = new Point(3, 4);
        Object objB = new Point(4, 2);

        Point control = new Point(3, 4);

        boolean valueAOne = control.equal(objA);
        boolean valueATwo = control.modifiedEqual(objA);

        boolean valueBOne = control.equal(objB);
        boolean valueBTwo = control.equal(objB);


        System.out.print("obj A (valueAOne) = " + valueAOne);
        System.out.print("obj A (valueATwo) = " + valueATwo);
    }
}