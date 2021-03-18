package be.jochenhansoul;

/*
(5) Schrijf een programma dat een paswoord vraagt als input (een String)
Het programma kijkt vervolgens na of de ingegeven String een sterk paswoord is. Een sterk paswoord moet aan de volgende voorwaarden voldoen:



- minimum 16 characters
- moet minimaal 1 kleine letter bevatten (a - z) -->
- moet minimaal 1 grote letter bevatten (A - Z)
- moet minimaal 1 speciaal character bevatten (bv: !, #, %, $, &, ...)
 */

import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuePassword = true;
        while (continuePassword) {
            System.out.println("Enter password");
            String password = input.nextLine();

            if (password.length() >= 16
                    && !password.equals(password.toLowerCase())
                    && !password.equals(password.toUpperCase())
                    && !password.equals(password.replaceAll("[!#%$&]", ""))) {
                System.out.println("Sterk passwoord");
            } else {
                System.out.println("Zwak passwoord");
            }
            System.out.println("Volgend passwoord? true/false");
            continuePassword = input.nextBoolean();
            input.nextLine();
        }
        input.close();
    }
}
