package be.jochenhansoul.general;

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
}