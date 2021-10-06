package be.jochenhanoul.singleton;

/*
conditions:
1. 1 instance only....
final >> mag niet veranderen...
wij >> geven de code het instance
wij >> zet snoepjes(container) "constructor" waar de andere code er niet aankan
    ENCAPSULATION
2. 'eASY' access to said instance

this is invented by the group of four

the new gang of four
uncle bob (roger martin)
linus thorvald

Deze code word allemaal gedaan bij het opstarten van het programma.
Het grote verschil is dat dit obj dan altijd word aangemaakt
bij de andere word het obj mogelijk nooit aangemaakt.

EAGER <> LAZY
wat als het aanmaken van uw instantie i.p.v. 10 nanoseconden 10 seconden
duurt. Wanneer uw gebruiker eerst gegevens moet invoeren en dit obj nodig
is kan je het op de tweede manier aanmaken, wanneer de gebruiker de gegevens
invoert kan je het object ondertussen al laden.
*/

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    /*
    private static boolean alreadyMade = false;

    public static getInstance() {
        if (alreadyMade) {
            throw new Exception("only one instance of Singleton class allowed");
        } else {
            return new Singleton();
            alreadyMade = true;
        }
    }
    */
}
