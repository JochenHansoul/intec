package be.jochenhansoul.bank.service;

import be.jochenhansoul.bank.data.Address;
import be.jochenhansoul.bank.data.Customer;
import be.jochenhansoul.bank.data.Employee;
import be.jochenhansoul.bank.data.Person;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonFactory {
    private static int counter = 0;

    public static Person createPerson(Scanner scanner) {
        System.out.println("is de persoon een gewone werknemer of een klant? (\"werknemer\" voor gewone werknemer)");
        String typePerson = scanner.nextLine();

        System.out.println("geef de voornaam in");
        String firstName = scanner.nextLine();
        System.out.println("geef de achternaam in");
        String lastName = scanner.nextLine();
        System.out.println("Geef de straat in");
        String street = scanner.nextLine();
        System.out.println("geef het huisnummer in");
        int nr = scanner.nextInt();
        scanner.nextLine();
        System.out.println("geef het nummer aditie in");
        String nrAddition = scanner.nextLine();
        System.out.println("geef de postcode in");
        int postcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("geef de stad in");
        String city = scanner.nextLine();
        System.out.println("geef het land in");
        String country = scanner.nextLine();

        LocalDate date = LocalDate.now();

        if (typePerson.equals("werknemer")) {
            return new Employee(++counter, firstName, lastName, new Address(street, nr, nrAddition, postcode, city, country), date);
        } else {
            return new Customer(++counter, firstName, lastName, new Address(street, nr, nrAddition, postcode, city, country), date);
        }
    }
}
