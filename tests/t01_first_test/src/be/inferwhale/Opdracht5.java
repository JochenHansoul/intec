package be.inferwhale;

import java.util.Scanner;

public class Opdracht5 {
    public static void main(String[] args) {
        /*
        (5) Schrijf een programma dat een paswoord vraagt als input (een String)
        Het programma kijkt vervolgens na of de ingegeven String een sterk paswoord is.
        Een sterk paswoord moet aan de volgende voorwaarden voldoen:

        x minimum 16 characters
        - moet minimaal 1 kleine letter bevatten (a - z) -->
        - moet minimaal 1 grote letter bevatten (A - Z)
        - moet minimaal 1 speciaal character bevatten (bv: !, #, %, $, &, ...)
         */

        String password = requestPassword();
        boolean isStronkPassword = evaluatePassword(password);

        if (isStronkPassword) System.out.println("Your password is very stronk!");
        else System.out.println("Your password is very weaksauce!!");
    }

    public static boolean evaluatePassword(String pwd) {
        if (pwd.length() < 16) return false;

        boolean hasSmallChar = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z') {
                hasSmallChar = true;
                break;
            }
        }
        if (!hasSmallChar) return false;

        boolean hasCapitalChar = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) >= 'A' && pwd.charAt(i) <= 'Z') {
                hasCapitalChar = true;
                break;
            }
        }
        if (!hasCapitalChar) return false;

        boolean hasSpecialChar = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) == '!' ||
                    pwd.charAt(i) == '#' ||
                    pwd.charAt(i) == '$' ||
                    pwd.charAt(i) == '~') {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar) return false;

        return true;
    }

    public static String requestPassword() {
        System.out.println("Please enter password for evaluation: ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}
