package be.jochenhansoul.opdracht1;

import be.jochenhansoul.general.*;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {
        TextPrinter tp = new TextPrinter(
            "Hello this is an example of a sentence containing words");

        System.out.println("***words containing 'e'***");
        tp.printFilteredWords((s) -> s.contains("e"));

        System.out.println("***words containing more then four letters***");
        tp.printFilteredWords((s) -> s.length() > 4);

        System.out.println("***words starting with letter 'a'***");
        tp.printFilteredWords((s) -> s.charAt(0) == 'a');

        System.out.println("***words with second letter 'e'***");
        tp.printFilteredWords((s) -> s.length() > 1 && s.charAt(1) == 'e');

        System.out.println("***words that contain two letters 'e'***");
        tp.printFilteredWords((s) -> s.contains("e") && s.substring(s.indexOf('e') + 1).contains("e"));
    }
}
