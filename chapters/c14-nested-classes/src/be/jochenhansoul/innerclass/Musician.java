package be.jochenhansoul.innerclass;

public class Musician {
    public class Instrument {
        public void makeSound() {
            System.out.println("instrument makes sound");
        }
    }

    public void play() {
        Instrument instrument = new Instrument();
        instrument.makeSound();
    }
}
