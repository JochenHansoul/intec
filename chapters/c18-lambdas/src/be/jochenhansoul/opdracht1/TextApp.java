package be.jochenhansoul.opdracht1;

public class TextApp {
    public static void main(String[] args) {
        TextPrinter tp = new TextPrinter(
            "Hello this is an example of a sentence containing words");

        System.out.println("***words containing 'e'***");
        tp.printFilteredWords((s) -> s.contains("e"));

        System.out.println("***words containing more then four letters***");
        tp.printFilteredWords((s) -> s.length() > 4);

        System.out.println("***words starting with letter 'a'***");
        tp.printFilteredWords((s) -> s.substring(0, 1).equals("a"));

        System.out.println("***words with second letter 'e'***");
        tp.printFilteredWords((s) -> (s.length() > 1) ? s.substring(1, 2).equals("e") : false);

    }
}
