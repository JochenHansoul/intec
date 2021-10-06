package be.jochenhansoul;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef uw naam in:");
        String name = input.nextLine();

        name = name
                .replace('o', '0')
                .replace('e', '3')
                .replace('s', '5');

        System.out.println("Hallo " + name);
        input.close();
    }
}
