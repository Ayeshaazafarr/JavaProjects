package Q5;
public class MultipleTimers {

    public static void main(String[] args) {

        Thread timer1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Timer 1 (2s) finished");
            } catch (InterruptedException e) {
                System.out.println("Timer 1 interrupted");
            }
        });

        Thread timer2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("Timer 2 (4s) finished");
            } catch (InterruptedException e) {
                System.out.println("Timer 2 interrupted");
            }
        });

        Thread timer3 = new Thread(() -> {
            try {
                Thread.sleep(6000);
                System.out.println("Timer 3 (6s) finished");
            } catch (InterruptedException e) {
                System.out.println("Timer 3 interrupted");
            }
        });

        timer1.start();
        timer2.start();
        timer3.start();
    }
}
