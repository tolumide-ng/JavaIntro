public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;

    private int id;
    
    private static int numberOfBicycles = 0;

    public Bicycle(int gear, int speed, int cadence) {
        this.gear = gear;
        this.speed = speed;
        this.cadence = cadence;

        this.id = ++numberOfBicycles;
    }

    public int getID () {
        return this.id;
    }

    public static int getNumberOfBicycles() {
        return Bicycle.numberOfBicycles;
    }

    public int getCadence() {
        return this.cadence;
    }

    public int getGear() {
        return this.gear;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setGear(int newValue) {
        this.gear = newValue;
    }

    public void applyBreak(int decrement) {
        this.speed -= decrement;
    }

    public void speedUp(int increment) {
        this.speed += increment;
    }

    public void setCadence(int newValue) {
        this.cadence = newValue;
    }
}
