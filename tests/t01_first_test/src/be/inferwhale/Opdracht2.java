package be.inferwhale;

public class Opdracht2 {
    public static void main(String[] args) {
        /*
        (2) Grootste gemene deler
        Schrijf een programma dat de "Grootste Gemene Deler" (GGD) zoekt van 2 integers.
        De GGD van 2 integers is de grootste integer die beide getallen kan delen zonder rest.
        Voorbeeld: gegeven 2 integers: 15 en 25 > de GGD is 5, want dat is het grootste getal dat beide integers kan delen zonder een rest.
         */
        int number1 = 100;
        int number2 = 25;

        int maxDivisor = 1;
        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) maxDivisor = i;
        }

        System.out.printf("De GGD van %d en %d is %d", number1, number2, maxDivisor);
    }
}
