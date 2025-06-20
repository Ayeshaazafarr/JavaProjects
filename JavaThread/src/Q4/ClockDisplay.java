package Q4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockDisplay implements Runnable {

    private Thread thread;
    private boolean running;

    public ClockDisplay() {
        thread = new Thread(this);
        running = false;
    }

    public void start() {
        if (!running) {
            running = true;
            thread.start();
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        while (running) {
            Date now = new Date();
            String timeString = formatter.format(now);
            System.out.println(timeString);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        ClockDisplay clock = new ClockDisplay();
        clock.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clock.stop();
    }
}
