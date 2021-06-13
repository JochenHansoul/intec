package be.jochenhansoul.opdracht4;

import be.jochenhansoul.general.*;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Person[] persons = new Person[] {
                new Person("first1", "last1", Gender.MALE, 1, 50F, 1.7F),
                new Person("first2", "last2", Gender.OTHER, 2, 50F, 1.7F),
                new Person("first3", "last3", Gender.FEMALE, 3, 50F, 1.7F),
                new Person("first3", "last3", Gender.UNKNOWN, 34, 50F, 1.7F)
        };
        System.out.println("Female:");
        Stream.of(persons)
                .filter(o -> o.getGender().equals(Gender.FEMALE))
                .forEach(System.out::println);

        System.out.println("Older then three:");
        Stream.of(persons)
                .filter(o -> o.getAge() >= 3)
                .forEach(System.out::println);

        System.out.println("All ages:");
        Stream.of(persons)
                .map(Person::getAge)
                .forEach(System.out::println);

        System.out.println("First and last name:");
        Stream.of(persons)
                .map(o -> o.getFirstName() + " " + o.getLastName())
                .forEach(System.out::println);

        System.out.println("Gemiddeld leeftijd:");
        long amount = Stream.of(persons)
                .count();
        long sum = Stream.of(persons)
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sum / amount);

        System.out.println("maximum leeftijd");
        Optional<Integer> max = Stream.of(persons)
                .map(Person::getAge)
                .max(Comparator.comparing(Integer::valueOf));
        System.out.println(max.get());

        System.out.println("minimum leeftijd");
        Optional<Integer> min = Stream.of(persons)
                .map(Person::getAge)
                .min(Comparator.comparing(Integer::valueOf));
        System.out.println(min.get());
    }
}
