package be.jochenhansoul.opdracht1;

import java.util.stream.*;

public class Source {
    public static void main(String[] args) {
        // part 1
        String[] array1 = new String[]{"a", "b", "c", "d", "e"};
        Stream.of(array1)
            .forEach(System.out::println);

        // part 2
        IntStream.range(0, 100)
            .forEach((s) -> System.out.print(s + ", "));

        // part 3
    }
}
