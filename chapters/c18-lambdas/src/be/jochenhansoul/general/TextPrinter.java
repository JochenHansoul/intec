package be.jochenhansoul.general;

import be.jochenhansoul.opdracht1.WordFilter;
import be.jochenhansoul.opdracht2.WordProcessor;

public class TextPrinter {
    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }

    public void printFilteredWords(WordFilter filter) {
        for (String w : sentence.split(" ")) {
            if (filter.isValid(w)) {
                System.out.println(w);
            }
        }
    }
}
