package be.jochenhansoul.opdracht1;

import java.util.stream.*;

public class Source {
    public static void main(String[] args) {
        String[] array1 = new String[]{"a", "b", "c", "d", "e"};
        Stream.of(array1)
            .forEach(System.out::println);
    }
}
