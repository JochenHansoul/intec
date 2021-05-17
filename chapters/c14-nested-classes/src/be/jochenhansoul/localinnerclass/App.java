package be.jochenhansoul.innerclass;

public class App {
    public static void main(String[] args) {
        Musician musician = new Musician();
        musician.play();

        // instnatiate inner class
        Musician.Instrument instrument = musician.new Instrument();
        instrument.makeSound();
    }
}
