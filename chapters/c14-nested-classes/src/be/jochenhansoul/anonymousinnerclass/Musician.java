package be.jochenhansoul.localinnerclass;

public class Musician {

    public void play() {
        Playable instrument = new Playable() {
            public void makeSound() {
                System.out.println("instrument makes sound");
            }
        }
        instrument.makeSound();
    }
}
