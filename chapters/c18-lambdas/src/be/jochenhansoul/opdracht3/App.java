package be.jochenhansoul.opdracht3;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        String hello = "Hello, is it me you're looking for";

        System.out.println("predicate:");
        TextPrinter tp = new TextPrinter("water is wet");
        tp.printFilteredWords((s) -> s.contains("a") && s.contains("e"));

        System.out.println("\nUnbound method reference:");
        TextPrinter tp1 = new TextPrinter(hello);
        tp1.printProcessedWords(String::toLowerCase);

        System.out.println("\nPrint numbers:");
        TextPrinter tp2 = new TextPrinter("100 200 300");
        tp2.printNumberValues(BigDecimal::new);

        System.out.println("\nPrint sum numbers");
        tp2.printSum(BigDecimal::new);

        System.out.println("\nprint reversed words:");
        TextPrinter tp3 = new TextPrinter(
                "this is a sentence with reversed words",
                (s) -> System.out.println("reversed: " + s));
        tp3.printProcessedWords((s) -> new StringBuilder(s).reverse().toString().toUpperCase());
    }
}
