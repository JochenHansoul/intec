package be.jochenhansoul.opdracht1;

public class TextApp {
    public static void main(String[] args) {
        TextPrinter tp = new TextPrinter(
            "Hello this is an example of a sentence containing words");

        System.out.println("***words containing 'e'***");
        tp.printFilteredWords((s) -> s.contains("e"));
    }
}
