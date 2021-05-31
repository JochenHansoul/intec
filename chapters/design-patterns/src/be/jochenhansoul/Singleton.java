package be.jochenhanoul;

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

*/

public class Singleton {
    private static Singleton instance = new Singleton();
    //private static boolean alreadyMade = false;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    /*public static getInstance() {
        if (alreadyMade) {
            throw new Exception("only one instance of Singleton class allowed");
        } else {
            return new Singleton();
            alreadyMade = true;
        }
    }
    */
}
