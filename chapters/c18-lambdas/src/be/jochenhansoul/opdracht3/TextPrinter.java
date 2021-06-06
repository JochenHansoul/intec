package be.jochenhansoul.opdracht3;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Predicate;

public class TextPrinter {
    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }

    public void printFilteredWords(Predicate<String> predicate) {
        for (String w : sentence.split(" ")) {
            if (predicate.test(w)) {
                System.out.println(w);
            }
        }
    }

    public void printProcessedWords(Function<String, String> processor) {
        for (String w : sentence.split(" ")) {
            System.out.println(processor.apply(w));
        }
    }

    public void printNumberValues(Function<String, BigDecimal> parser) {
        for (String w : sentence.split(" ")) {
            System.out.println(parser.apply(w));
        }
    }

    public void printSum(Function<String, BigDecimal> parser) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (String w : sentence.split(" ")) {
            bigDecimal = bigDecimal.add(parser.apply(w));
        }
        System.out.println(bigDecimal);
    }
}
