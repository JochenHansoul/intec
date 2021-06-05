package be.jochenhansoul.opdracht1;

public class TextScrambler {
    String s;

    public TextScrambler(String s) {
        this.s = s;
    }

    public String scramble() {
        return this.s
                .replace('a', '@')
                .replace('e', '€')
                .replace('I', '1')
                .replace('o', '0');
    }
}
