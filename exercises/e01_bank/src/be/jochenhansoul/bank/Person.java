package be.jochenhansoul.bank;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Person {
    private static int idCounter = 0;

    public final int ID;
    private String firstName;
    private String lastName;
    private Address address;
    private List<ContactInfo> contactInfos;

    public Person(String firstName, String lastName, Address address) {
        this(firstName, lastName, address, new ArrayList());
    }

    public Person(
        String firstName,
        String lastName,
        Address address,
        ArrayList<ContactInfo> contactInfos) {

        this.ID = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInfos = contactInfos;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.address;
    }
}
