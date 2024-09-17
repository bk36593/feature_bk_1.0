public class CeilingFanProgram {

    private int speed;
    private boolean isReversed;


    public CeilingFanProgram() {
        this.speed = 0; // Fan starts at off (speed 0)
        this.isReversed = false; // Fan starts in normal direction
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isReversed() {
        return isReversed;
    }

    // Pull cord 1: Increase speed
    public void pullingCordSpeed() {
        speed = (speed + 1) % 4; // Cycle through speeds (0, 1, 2, 3, then back to 0)
    }

    // Pull cord 2: Reverse direction
    public void pullingCordDirection() {
        isReversed = !isReversed; // Toggle the direction
    }


    public String getStatus() {
        return "Fan speed: " + speed + " | Direction: " + (isReversed ? "Reversed" : "Normal");
    }
}