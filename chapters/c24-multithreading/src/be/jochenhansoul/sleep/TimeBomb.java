package be.jochenhansoul.sleep;

public class TimeBomb extends Thread {
    private int time;
    private boolean disarmed = false;

    public TimeBomb(int time) {
        this.time = time;
    }

    public void activate() {
        this.start();
    }

    public void disarm() {
        this.disarmed = true;
    }

    @Override
    public void run() {
        while (!this.disarmed && this.time > 0) {
            System.out.println("Timebomb ticking: " + --this.time + " seconds left");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        if (disarmed) {
            System.out.println("Disarmed!!!");
        } else {
            System.out.println("Booooooooooooooom!");
        }
    }
}
