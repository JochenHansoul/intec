package be.inferwhale;

import java.util.Scanner;

public class Opdracht3 {
    /*
    Schrijf een programma dat de gebruiker zijn naam vraagt.
    Het programma drukt vervolgens "Hallo <gebruikersnaam>" af.
    Vervang <gebruikersnaam> door de naam van de gebruiker in 'leet'-code.

    Leet-code:
    - een 'o' wordt vervangen door een 0 (zero)
    - een 'e' wordt vervangen door een 3
    - een 's' wordt vervangen door een 5
     */

    public static void main(String[] args) {
        System.out.println("Gelieve uw naam in te geven:");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();

        name = name.replace('o', '0');
        name = name.replace('e', '3');
        name = name.replace('s', '5');

//        name = name.replace('o', '0')
//                .replace('e', '3')
//                .replace('s', '5');

        System.out.println("Hallo " + name);
    }
}
