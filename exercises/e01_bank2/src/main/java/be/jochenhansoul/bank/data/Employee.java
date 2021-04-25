package be.jochenhansoul.bank.data;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee extends Person {
    public Employee(int id, String firstName, String lastName, Address address, LocalDate birthDate) {
        this(id, firstName, lastName, address, birthDate, new ArrayList<>());
    }
    public Employee(int id, String firstName, String lastName, Address address, LocalDate birthDate, ArrayList<ContactInfo> contactInfos) {
        super(id, firstName, lastName, address, birthDate, contactInfos);
    }
}
