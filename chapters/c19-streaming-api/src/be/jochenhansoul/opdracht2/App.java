package be.jochenhansoul.opdracht2;

import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) {
        long amount = IntStream.of(1, 2, 3, 4, 5)
            .count();
        System.out.println(amount);

        OptionalInt oi = IntStream.of(1, 2, 3, 4, 5)
            .max();
        oi.ifPresent(System.out::println);
        // System.out.println(oi.getAsInt()); // werkt

        IntStream.of(1, 2, 3, 4, 5)
            .min()
            .ifPresent(System.out::println);

        IntStream.of(1, 2, 3, 4, 5)
            .average()
            .ifPresent(System.out::println);

        int sum = IntStream.of(1, 2, 3, 4, 5)
            .sum();
        System.out.println(sum);

        int result = IntStream.of(1, 2, 3, 4, 5)
            .reduce(0, (acc, el) -> acc + (int) Math.pow(el, 2));
        System.out.println(result);
    }
}
