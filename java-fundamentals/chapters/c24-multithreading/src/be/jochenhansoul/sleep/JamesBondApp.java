package be.jochenhansoul.sleep;

import java.util.Random;

public class JamesBondApp {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random(4);
        TimeBomb bomb = new TimeBomb(10);
        bomb.activate();
        Thread.sleep(rand.nextInt(2000));
        bomb.disarm();
    }
}
