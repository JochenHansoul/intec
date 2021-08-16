package be.jochenhansoul.bank.data;

import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Person {
    public final int ID;

    private final List<ContactInfo> contactInfos;
    private String firstName;
    private String lastName;
    private Address address;
    private LocalDate birthDate;

    public Person(int id, String firstName, String lastName, Address address) {
        this(id, firstName, lastName, address, LocalDate.of(1990, 1, 1));
    }

    public Person(int id, String firstName, String lastName, Address address, LocalDate birthDate) {
        this(id, firstName, lastName, address, birthDate, new ArrayList<>());
    }

    public Person(
        int id,
        String firstName,
        String lastName,
        Address address,
        LocalDate birthDate,
        ArrayList<ContactInfo> contactInfos) {

        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
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

    public ContactInfo[] getContacts() {
        return this.contactInfos.toArray(new ContactInfo[0]).clone();
    }

    public String getContactString() {
        StringBuilder sb = new StringBuilder();
        for (ContactInfo contact : getContacts()) {
            sb.append(contact.toString());
        }
        return sb.toString();
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
        return String.format("%s %s address: %s contacts: %s",
            this.firstName,
            this.lastName,
            this.address.toString(),
            this.getContactString());
    }
}
