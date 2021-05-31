package be.jochenhanoul;

public class Singleton {
    private static boolean alreadyMade = false;

    public Singleton() {
        if (alreadyMade) {
            throw new Exception("only one instance of Singleton class allowed");
        } else {
            alreadyMade = true;
        }
}
