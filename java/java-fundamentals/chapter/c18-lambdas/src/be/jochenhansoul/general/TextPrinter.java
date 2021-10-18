package be.jochenhansoul.general;

import java.math.BigDecimal;

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

    public void printProcessedWords(WordProcessor processor) {
        for (String w : sentence.split(" ")) {
            System.out.println(processor.process(w));
        }
    }

    public void printNumberValues(NumberParser parser) {
        for (String w : sentence.split(" ")) {
            System.out.println(parser.parse(w));
        }
    }

    public void printSum(NumberParser parser) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (String w : sentence.split(" ")) {
            bigDecimal = bigDecimal.add(parser.parse(w));
        }
        System.out.println(bigDecimal);
    }
}
