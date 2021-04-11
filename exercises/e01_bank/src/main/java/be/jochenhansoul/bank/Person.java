package be.jochenhansoul.bank;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Person {
    public final int ID;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address address;
    private List<ContactInfo> contactInfos;

    public Person(int id, String firstName, String lastName, LocalDate birthDate, Address address) {
        this(id, firstName, lastName, birthDate, address, new ArrayList());
    }

    public Person(
        int id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        Address address,
        ArrayList<ContactInfo> contactInfos) {

        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.contactInfos = contactInfos;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Address getAddress() {
        return this.address;
    }

    public ContactInfo[] getContacts(int i) {
        return this.contactInfos.toArray(new ContactInfo[0]).clone();
    }

    public void addContact(ContactInfo contactInfo) {
        this.contactInfos.add(contactInfo);
    }

    public void removeContact(int i) {
        this.contactInfos.remove(i);
    }

    @Override
    public int hashCode() {
        return this.ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Person person = (Person) o;
            return this.ID == person.ID;
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.address;
    }
}
