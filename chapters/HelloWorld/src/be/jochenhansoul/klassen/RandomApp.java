package be.jochenhansoul.klassen;

import java.util.Random;

public class RandomApp {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextInt());
        System.out.println(random.nextInt(51)); // 0 - 50
        System.out.println(random.nextInt(51) + 25); // 25 - 50
    }
}
