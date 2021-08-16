package be.jochenhansoul.opdracht1;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        StringBuilder sentence = new StringBuilder(scanner.nextLine());
        while (sentence.charAt(sentence.length() - 1) != '.') {
            System.out.println("Enter a sentence");
            sentence.append(" ").append(scanner.nextLine());
        }
        sentence.deleteCharAt(sentence.length() - 1);
        List<String> words = Arrays.asList(sentence.toString().split(" "));
        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.println(words.get(i));
        }
        System.out.println("amount of words: " + words.size());

        // set
        System.out.println("print a set of words:");
        Set<String> set = new HashSet<>(words);
        for (String word : set) {
            System.out.println(word);
        }
    }
}
