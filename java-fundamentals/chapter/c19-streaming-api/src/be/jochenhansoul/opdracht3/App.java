package be.jochenhansoul.opdracht3;

import be.jochenhansoul.general.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Person[] persons = new Person[] {
            new Person("first1", "last1", Gender.MALE, 1, 50F, 1.7F),
            new Person("first2", "last2", Gender.OTHER, 2, 50F, 1.7F),
            new Person("first3", "last3", Gender.FEMALE, 3, 50F, 1.7F),
            new Person("first3", "last3", Gender.UNKNOWN, 3, 50F, 1.7F)
        };

        Person[] newPersonArray = Arrays.stream(persons)
                .toArray(Person[]::new);

        for (Person person : newPersonArray) {
            System.out.println(person);
        }

        // just a stream test
        Stream<String> stream = Stream.generate(() -> "this is a string");
        stream.limit(1).forEach(System.out::println);
    }
}
