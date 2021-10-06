package be.jochenhansoul;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        String paragraph = "The metal–oxide–semiconductor field-effect transistor (MOSFET, MOS-FET, or MOS FET),"
                + " also known as the metal–oxide–silicon transistor (MOS transistor, or MOS),[1]"
                + " is a type of insulated-gate field-effect transistor that is fabricated by the controlled"
                + " oxidation of a semiconductor, typically silicon. The voltage of the covered gate determines"
                + " the electrical conductivity of the device; this ability to change conductivity with the amount"
                + " of applied voltage can be used for amplifying or switching electronic signals.";
        //paragraph = paragraph.replace('-', ' '); // doesn't seem to work
        paragraph = paragraph.replaceAll("[.,;()\\[\\]–]", " ");

        List<String> wordList = new ArrayList<>();
        for (String word : paragraph.split(" ")) {
            int amountOfLetters = word.length() - word.replaceAll("[a-zA-Z]", "").length();
            if (amountOfLetters > 5) {
                wordList.add(word);
            }
        }
        String[] arrayWordsMoreThanFiveLetters = wordList.toArray(new String[0]);
        for (String s : arrayWordsMoreThanFiveLetters) {
            System.out.println(s);
        }
    }
}
