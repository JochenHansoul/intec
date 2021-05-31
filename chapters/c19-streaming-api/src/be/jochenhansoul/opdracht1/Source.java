package be.jochenhansoul.opdracht1;

import java.util.Arrays;
import java.util.stream.*;

public class Source {
    public static void main(String[] args) {
        // part 1
        System.out.println("part 1");
        String[] array1 = new String[]{"a", "b", "c", "d", "e"};
        Stream.of(array1)
            .forEach((s) -> System.out.print(s + ", "));
        System.out.println("\n\n");

        // part 2
        System.out.println("part 2");
        IntStream.range(0, 100)
            .forEach((s) -> System.out.print(s + ", "));
        System.out.println("\n\n");

        // part 3
        System.out.println("part 3");
        Person[] persons = new Person[] {
            new Person("first1", "last1", Gender.MALE, 1, 50F, 1.7F),
            new Person("first2", "last2", Gender.OTHER, 2, 50F, 1.7F),
            new Person("first3", "last3", Gender.FEMALE, 3, 50F, 1.7F),
            new Person("first3", "last3", Gender.UNKNOWN, 3, 50F, 1.7F)
        };
        Stream<Person> personStream = Arrays.stream(persons);
        personStream.forEach(System.out::println);
    }
}
