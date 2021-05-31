package be.jochenhansoul.opdracht3;

import be.jochenhansoul.general.*;

public class App {
    public static void main(String[] args) {
        Person[] persons = new Person[] {
            new Person("first1", "last1", Gender.MALE, 1, 50F, 1.7F),
            new Person("first2", "last2", Gender.OTHER, 2, 50F, 1.7F),
            new Person("first3", "last3", Gender.FEMALE, 3, 50F, 1.7F),
            new Person("first3", "last3", Gender.UNKNOWN, 3, 50F, 1.7F)
        };
    }
}
