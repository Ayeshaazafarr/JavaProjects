package labTask;

public class lightBulb {
   
    private boolean isOn;

   
    public lightBulb() {
        isOn = false;
    }

    
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("The light bulb is now ON.");
        } else {
            System.out.println("The light bulb is already ON.");
        }
    }

   
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("The light bulb is now OFF.");
        } else {
            System.out.println("The light bulb is already OFF.");
        }
    }

    public void showStatus() {
        if (isOn) {
            System.out.println("The light bulb is ON.");
        } else {
            System.out.println("The light bulb is OFF.");
        }
    }
}