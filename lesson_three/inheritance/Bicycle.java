package inheritance;

public class Bicycle {
    public int cadence;
    public int gear;
    public int speed;

    public Bicycle(int cadence, int speed, int gear) {
        this.gear = gear;
        this.speed = speed;
        this.cadence = cadence;
    }

    public void setCadence(int value) {
        this.cadence = value;
    }

    public void setGear(int value) {
        this.gear = value;
    }

    public void applyBreak(int decrement) {
        this.speed -= decrement;
    }

    public void speedUp(int increment) {
        this.speed += increment;
    }
}
