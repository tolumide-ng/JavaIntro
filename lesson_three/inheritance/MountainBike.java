package inheritance;

public class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int height, int cadence, int speed, int gear) {
        super(cadence, speed, gear);
        this.seatHeight = height;
    }

    public void setHeight(int value) {
        this.seatHeight = value;
    }
}
