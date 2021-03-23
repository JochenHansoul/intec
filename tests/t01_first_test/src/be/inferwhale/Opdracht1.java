package be.inferwhale;

public class Opdracht1 {
    public static void main(String[] args) {
        /*
        (1) Schrijf een programma dat alle getallen van 0 tot 10_000 afdrukt die voldoen aan de volgende voorwaarden:
        - Geen even getallen
        - Geen getallen die deelbaar zijn door 5

        - Bonus point: druk ook het aantal gevonden of afgedrukte getallen af
         */
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            if (i % 2 != 0 && i % 5 != 0) {
                System.out.println(i);
                counter++;
            }
        }

        System.out.println(String.format("We found %d valid numbers.", counter));
    }
}
