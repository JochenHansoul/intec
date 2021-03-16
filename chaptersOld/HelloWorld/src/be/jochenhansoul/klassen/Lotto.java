package be.jochenhansoul.klassen;

import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            System.out.println(rand.nextInt(45) + 1);
        }
    }
}
