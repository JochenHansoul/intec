package be.jochenhansoul.klassen;

import java.util.Random;
import java.util.Scanner;

public class RandomAppWithInteraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("enter upper limit");
        int upperLimit = input.nextInt();
        int randomNumber = rand.nextInt(upperLimit + 1);
        boolean found = false;
        int counter = 0;
        while (!found && counter < 3) {
            System.out.println("enter number:");
            int n = input.nextInt();
            if (randomNumber == n) {
                found = true;
            } else {
                System.out.println((n < randomNumber) ? "too low" : "too high");
            }
            counter++;
        }
        System.out.println((found) ? "you have found it" : "too bad");
        input.close();
    }
}
