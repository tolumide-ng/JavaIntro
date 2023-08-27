public class Bicycle {
    boolean isMoving = false;
    int currentSpeed = 0;

    public static void main() {
        // isMoving = true;
        // currentSpeed+=1;
    };

    void applyBreaks() {
        if(isMoving) {
            currentSpeed--;
        } else {
            System.err.println("The bicycle has already stopped!");
        }
    }
}
