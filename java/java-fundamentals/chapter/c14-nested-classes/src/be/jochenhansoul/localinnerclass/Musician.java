package be.jochenhansoul.localinnerclass;

public class Musician {

    public void play() {
        class Instrument {
            public void makeSound() {
                System.out.println("instrument makes sound");
            }
        }

        Instrument instrument = new Instrument();
        instrument.makeSound();
    }
}
