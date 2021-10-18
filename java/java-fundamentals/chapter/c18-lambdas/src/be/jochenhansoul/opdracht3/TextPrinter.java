package be.jochenhansoul.opdracht3;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TextPrinter {
    private final String sentence;
    private final Consumer<String> consumer;

    public TextPrinter(String sentence) {
        this(sentence, System.out::print);
    }

    public TextPrinter(String sentence, Consumer<String> consumer) {
        this.sentence = sentence;
        this.consumer = consumer;
    }

    public void printFilteredWords(Predicate<String> predicate) {
        for (String w : sentence.split(" ")) {
            if (predicate.test(w)) {
                this.consumer.accept(w);
            }
        }
    }

    public void printProcessedWords(Function<String, String> processor) {
        for (String w : sentence.split(" ")) {
            consumer.accept(processor.apply(w));
        }
    }

    public void printNumberValues(Function<String, BigDecimal> parser) {
        for (String w : sentence.split(" ")) {
            consumer.accept(parser.apply(w).toString());
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
