package classes;

public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;


    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        speed = startSpeed;
        cadence = startCadence;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public int getSpeed() {
        return speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}
